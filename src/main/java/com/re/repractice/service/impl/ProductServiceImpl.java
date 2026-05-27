package com.re.repractice.service.impl;

import com.re.repractice.dto.request.ProductRequestDto;
import com.re.repractice.dto.response.ProductResponseDto;
import com.re.repractice.entity.Product;
import com.re.repractice.mapper.ProductMapper;
import com.re.repractice.repository.ProductRepository;
import com.re.repractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toProduct(productRequestDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? productMapper.toProductResponseDto(product) : null;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productRequestDto.getName());
            product.setPrice(productRequestDto.getPrice());
            product.setDescription(productRequestDto.getDescription());
            Product updatedProduct = productRepository.save(product);
            return productMapper.toProductResponseDto(updatedProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

