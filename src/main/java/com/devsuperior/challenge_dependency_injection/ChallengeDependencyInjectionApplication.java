package com.devsuperior.challenge_dependency_injection;

import com.devsuperior.challenge_dependency_injection.entities.Order;
import com.devsuperior.challenge_dependency_injection.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class ChallengeDependencyInjectionApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeDependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);

		Order order = new Order(1034, 150.00, 20.0);
		System.out.printf("Pedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f%n%n", orderService.total(order));

		Order order2 = new Order(2282, 800.00, 10.0);
		System.out.printf("Pedido código %d%n", order2.getCode());
		System.out.printf("Valor total: R$ %.2f%n%n", orderService.total(order2));

		Order order3 = new Order(1309, 95.90, 0.0);
		System.out.printf("Pedido código %d%n", order3.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order3));
	}
}
