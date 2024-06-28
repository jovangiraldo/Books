package com.example.Books;

import Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoApi;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);


	}
	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.MuestraMenu();
	}
}
