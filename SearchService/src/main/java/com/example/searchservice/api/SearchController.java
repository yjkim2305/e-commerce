package com.example.searchservice.api;

import com.example.searchservice.api.request.ProductTagsRegisterRequest;
import com.example.searchservice.application.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search/v1/add/tag")
    public void addTagCache(@RequestBody ProductTagsRegisterRequest rq) {
        searchService.addTagCache(rq.productId(), rq.tags());
    }

    @PostMapping("/search/v1/remove/tag")
    public void removeTagCache(@RequestBody ProductTagsRegisterRequest rq) {
        searchService.removeTagCache(rq.productId(), rq.tags());
    }

    @GetMapping("/search/v1/{tag}/products")
    public List<Long> getTagProductIds(@PathVariable(value = "tag") String tag) {
        return searchService.getProductIdsByTag(tag);
    }
}
