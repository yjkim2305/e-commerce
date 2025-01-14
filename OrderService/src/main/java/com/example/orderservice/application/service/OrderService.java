package com.example.orderservice.application.service;

import com.example.orderservice.api.response.ProductOrderDetailResponse;
import com.example.orderservice.application.dto.*;
import com.example.orderservice.application.repository.OrderRepository;
import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.OrderStatus;
import com.example.orderservice.feign.CategoryClient;
import com.example.orderservice.feign.DeliveryClient;
import com.example.orderservice.feign.PaymentClient;
import com.example.orderservice.infrastructure.entity.ProductOrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CategoryClient categoryClient;
    private final DeliveryClient deliveryClient;
    private final PaymentClient paymentClient;

    public OrderIntoDto createOrderInfo(Long userId, Long productId, Long count) {
        //상품 정보 조회
        ProductDto product = categoryClient.getProductById(productId);

        //결제 수단 정보 조회
        PaymentMethodDto paymentMethod = paymentClient.getPaymentMethod(userId);

        //배송지 정보 조회
        UserAddressDto userAddress = deliveryClient.getFirstAddress(userId);

        //주문 정보 생성
        ProductOrder order = orderRepository.save(ProductOrder.of(userId, productId, count, OrderStatus.INITIATED
                , null, null));


        return OrderIntoDto.of(order.getId(), paymentMethod, userAddress);
    }

    public ProductOrder process(Long orderId, Long paymentMethodId, Long addressId) {
        ProductOrder order = orderRepository.findById(orderId);

        //상품 정보 조회
        ProductDto product = categoryClient.getProductById(order.getProductId());

        //결제
        PaymentDto payment = paymentClient.processPayment(
                PaymentRegisterDto.of(order.getId(), order.getUserId(),
                        product.getPrice() * order.getCount(), paymentMethodId)
        );

        //배송 요청
        UserAddressDto address = deliveryClient.getAddress(addressId);

        DeliveryDto delivery = deliveryClient.processDelivery(
                DeliveryRegisterDto.of(
                        order.getId(),
                        product.getName(),
                        order.getCount(),
                        address.getAddress()
                )
        );

        //재고 감소
        categoryClient.decreaseStockCount(order.getProductId(), ProductDecreaseStockCountDto.from(order.getCount()));
        
        //주문 정보 업데이트
        order.modifyOrderInfo(payment.getId(), delivery.getId(), OrderStatus.DELIVERY_REQUESTED);

        return orderRepository.save(order);
    }

    public List<ProductOrder> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public ProductOrderDetailDto getOrderDetail(Long orderId) {
        ProductOrder order = orderRepository.findById(orderId);

        PaymentDto payment = paymentClient.getPayment(order.getPaymentId());
        DeliveryDto delivery = deliveryClient.getDelivery(order.getDeliveryId());

        return ProductOrderDetailDto.of(order, payment, delivery);
    }



}
