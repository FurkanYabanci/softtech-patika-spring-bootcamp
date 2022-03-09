package org.example.case3FurkanYabanci.controller;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.dto.ProductDto;
import org.example.case3FurkanYabanci.dto.request.ProductSaveRequestDto;
import org.example.case3FurkanYabanci.dto.request.ProductUpdateRequestDto;
import org.example.case3FurkanYabanci.generic.dto.RestResponse;
import org.example.case3FurkanYabanci.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity getAll(){
        List<ProductDto> productDtoList = productService.findAll();
        return ResponseEntity.ok(RestResponse.of(productDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        ProductDto productDto = productService.getById(id);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductSaveRequestDto productSaveRequestDto) {
        ProductDto productDto = productService.save(productSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        ProductDto productDto = productService.update(productUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
