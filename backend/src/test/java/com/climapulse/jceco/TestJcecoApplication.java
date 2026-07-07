package com.climapulse.jceco;

import org.springframework.boot.SpringApplication;

public class TestJcecoApplication {

	public static void main(String[] args) {
		SpringApplication.from(JcecoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
