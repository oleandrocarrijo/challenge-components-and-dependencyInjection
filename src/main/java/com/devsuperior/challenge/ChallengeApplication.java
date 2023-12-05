package com.devsuperior.challenge;

import com.devsuperior.challenge.entities.Order;
import com.devsuperior.challenge.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o código do produto: ");
		int code = sc.nextInt();
		System.out.print("Digite o valor do produto: ");
		double basic = sc.nextDouble();
		System.out.print("Digite o valor do desconto: ");
		double discount = sc.nextDouble();
		Order order = new Order(code, basic, discount);

		System.out.printf("Pedido código %d%n", code);
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
	}
}
