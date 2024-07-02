package com.yourticket.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yourticket")
public class YourticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourticketApplication.class, args);
	}

}
