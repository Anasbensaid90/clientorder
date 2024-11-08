package com.anasdev.clientorder;

import com.anasdev.clientorder.model.Order;
import com.anasdev.clientorder.repo.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.stream.Stream;

@SpringBootApplication
public class ClientorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientorderApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository) {
		return args -> {
			Stream.of(
					Order.builder().clientId(1L).price(99.99).orderTime(Instant.now()).build(),
					Order.builder().clientId(2L).price(49.99).orderTime(Instant.now()).build(),
					Order.builder().clientId(3L).price(19.99).orderTime(Instant.now()).build(),
					Order.builder().clientId(1L).price(29.99).orderTime(Instant.now()).build()
			).forEach(orderRepository::save);

			orderRepository.findAll().forEach(System.out::println);
		};
	}
}
