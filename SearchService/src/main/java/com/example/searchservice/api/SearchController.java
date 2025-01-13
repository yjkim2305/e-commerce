package com.example.searchservice.api;

import com.example.searchservice.api.request.ProductTagsRegisterRequest;
import com.example.searchservice.application.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search/v1/addTagCache")
    public void addTagCache(ProductTagsRegisterRequest rq) {
        searchService.addTagCache(rq.productId(), rq.tags());
    }

    @PostMapping("/search/v1/removeTagCache")
    public void removeTagCache(ProductTagsRegisterRequest rq) {
        searchService.removeTagCache(rq.productId(), rq.tags());
    }

    @GetMapping("/search/v1/{tag}/productIds")
    public void getTagProductIds(@PathVariable(value = "tag") String tag) {
        searchService.getProductIdsByTag(tag);
    }
}
