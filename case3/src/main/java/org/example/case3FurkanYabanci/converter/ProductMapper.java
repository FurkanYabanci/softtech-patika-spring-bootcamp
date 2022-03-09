package org.example.case3FurkanYabanci.converter;

import org.example.case3FurkanYabanci.dto.ProductDto;
import org.example.case3FurkanYabanci.dto.request.ProductSaveRequestDto;
import org.example.case3FurkanYabanci.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequestDto productSaveRequestDto);
    ProductDto convertToProductDto(Product product);
    List<ProductDto> convertToProductDtoList(List<Product> productList);


}
