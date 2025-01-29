package com.espe.micro_cursos_uwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroCursosUwuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCursosUwuApplication.class, args);
	}

}
