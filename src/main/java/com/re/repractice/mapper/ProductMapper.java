package com.re.repractice.mapper;

import com.re.repractice.dto.request.ProductRequestDto;
import com.re.repractice.dto.response.ProductResponseDto;
import com.re.repractice.entity.Product;

public interface ProductMapper {
    ProductResponseDto toProductResponseDto(Product product);
    Product toProduct(ProductRequestDto productRequestDto);
}

