package com.example.EntregaFinal;

import com.example.EntregaFinal.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntregaFinalApplication {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(EntregaFinalApplication.class, args);
	}

}
