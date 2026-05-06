package com.milcolores.system_pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemPosApplication.class, args);
		System.out.println("¡El sistema se ha iniciado correctamente!");
		System.out.println("¡Bienvenido al sistema POS de Mil Colores!");
		System.out.println("Puerto:" + System.getenv("PORT"));
	}

}
