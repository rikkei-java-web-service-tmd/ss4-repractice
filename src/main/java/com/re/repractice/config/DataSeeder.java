package com.re.repractice.config;

import com.re.repractice.entity.Product;
import com.re.repractice.entity.User;
import com.re.repractice.repository.ProductRepository;
import com.re.repractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    Product.builder()
                            .name("Laptop Dell XPS 13")
                            .price(25000000.0)
                            .description("Laptop van phong mong nhe")
                            .build(),
                    Product.builder()
                            .name("iPhone 15")
                            .price(22000000.0)
                            .description("Dien thoai Apple 128GB")
                            .build(),
                    Product.builder()
                            .name("Tai nghe Sony WH-1000XM5")
                            .price(7500000.0)
                            .description("Tai nghe chong on")
                            .build()
            ));
        }

        if (userRepository.count() == 0) {
            userRepository.saveAll(List.of(
                    User.builder()
                            .name("Nguyen Van A")
                            .email("vana@example.com")
                            .build(),
                    User.builder()
                            .name("Tran Thi B")
                            .email("thib@example.com")
                            .build()
            ));
        }
    }
}
