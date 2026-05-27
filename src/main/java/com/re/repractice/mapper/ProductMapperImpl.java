package com.re.repractice.mapper;

import com.re.repractice.dto.request.ProductRequestDto;
import com.re.repractice.dto.response.ProductResponseDto;
import com.re.repractice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements com.re.repractice.mapper.ProductMapper {
    @Override
    public ProductResponseDto toProductResponseDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }

    @Override
    public Product toProduct(ProductRequestDto productRequestDto) {
        if (productRequestDto == null) {
            return null;
        }
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .description(productRequestDto.getDescription())
                .build();
    }
}

