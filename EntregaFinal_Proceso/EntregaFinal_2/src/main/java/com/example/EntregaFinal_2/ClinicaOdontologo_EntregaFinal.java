package com.example.EntregaFinal_2;

import com.example.EntregaFinal_2.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologo_EntregaFinal {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ClinicaOdontologo_EntregaFinal.class, args);
	}
}
