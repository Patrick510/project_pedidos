package com.produtos.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidosApplication {

	public static void main(String[] args) {

		SpringApplication.run(PedidosApplication.class, args);
		System.out.println("Rodando API");
	}

}
