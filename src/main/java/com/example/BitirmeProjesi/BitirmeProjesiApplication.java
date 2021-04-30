package com.example.BitirmeProjesi;

import com.example.BitirmeProjesi.Entity.Broadcast;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BitirmeProjesiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BitirmeProjesiApplication.class, args);

	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
