package br.com.hotelcompensa.microservice.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HotelmsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmsaApplication.class, args);
	}

}
