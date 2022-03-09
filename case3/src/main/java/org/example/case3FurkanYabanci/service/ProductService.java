package org.example.case3FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.converter.ProductMapper;
import org.example.case3FurkanYabanci.dto.ProductDto;
import org.example.case3FurkanYabanci.dto.request.ProductSaveRequestDto;
import org.example.case3FurkanYabanci.dto.request.ProductUpdateRequestDto;
import org.example.case3FurkanYabanci.generic.exception.ItemNotFoundException;
import org.example.case3FurkanYabanci.generic.model.BaseAdditionalFields;
import org.example.case3FurkanYabanci.model.Product;
import org.example.case3FurkanYabanci.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll(){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = ProductMapper.INSTANCE.convertToProductDtoList(productList);
        return productDtoList;
    }

    public ProductDto getById(long id){
        Product product = findById(id);
        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return productDto;
    }

    public ProductDto save(ProductSaveRequestDto productSaveRequestDto){
        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveRequestDto);
        setAdditionalFields(product);
        product = productRepository.save(product);
        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return productDto;
    }

    public ProductDto update(ProductUpdateRequestDto productUpdateRequestDto){
        Product product = findById(productUpdateRequestDto.getId());
        setAdditionalFields(product);
        product.setPrice(productUpdateRequestDto.getPrice());
        product = productRepository.save(product);
        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return productDto;
    }

    public void delete(long id){
        Product product = findById(id);
        productRepository.delete(product);
    }

    protected Product findById(long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Product Not Found!"));
        return product;
    }

    private void setAdditionalFields(Product product){
        BaseAdditionalFields baseAdditionalFields = new BaseAdditionalFields();
        baseAdditionalFields.setUpdateDate(new Date());
        if (baseAdditionalFields.getCreateDate() == null){
            baseAdditionalFields.setCreateDate(new Date());
            product.setBaseAdditionalFields(baseAdditionalFields);
        }
    }


}
