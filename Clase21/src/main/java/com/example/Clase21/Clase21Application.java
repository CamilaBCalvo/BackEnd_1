package com.example.Clase21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Clase21Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase21Application.class, args);
	}

@GetMapping("/miSistema")
	public String hola(){
		return "hola mundo";
	}
}
