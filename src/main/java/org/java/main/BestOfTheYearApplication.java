package org.java.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.java.main.controller"})
public class BestOfTheYearApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestOfTheYearApplication.class, args);
	}
}
