package com.dh.sportspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SportSpotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportSpotApplication.class, args);
	}

}
