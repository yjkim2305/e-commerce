package com.example.deliveryservice.schedule;

import com.example.deliveryservice.application.repository.DeliveryRepository;
import com.example.deliveryservice.consumer.dto.KafkaDeliveryStatusMessage;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.enums.DeliveryStatus;
import com.example.deliveryservice.kafka.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryStatusUpdator {

    private final DeliveryRepository deliveryRepository;
    private final KafkaMessageProducer kafkaMessageProducer;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Scheduled(fixedDelay = 10000)
    public void deliveryStatusUpdator() {
        log.info("--- delivery status update schedule start ---");
        //delivery status를 임의로 변경하는 스케줄링
        deliveryRepository.findAllByStatus(DeliveryStatus.IN_DELIVERY)
                .forEach(delivery -> {
                    delivery.modifyStatus(DeliveryStatus.COMPLETED);
                    deliveryRepository.save(delivery);

                    publishStatusChange(delivery);
                });

        deliveryRepository.findAllByStatus(DeliveryStatus.REQUESTED)
                .forEach(delivery -> {
                    delivery.modifyStatus(DeliveryStatus.IN_DELIVERY);
                    deliveryRepository.save(delivery);

                    publishStatusChange(delivery);
                });
    }

    private void publishStatusChange(Delivery delivery) {
        kafkaMessageProducer.send("delivery_status_update", KafkaDeliveryStatusMessage.of(delivery.getOrderId(), delivery.getId(), delivery.getStatus()));
    }
}
