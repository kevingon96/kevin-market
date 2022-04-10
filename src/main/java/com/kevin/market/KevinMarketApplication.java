package com.kevin.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.kevin.market"})
public class KevinMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KevinMarketApplication.class, args);
	}

}
