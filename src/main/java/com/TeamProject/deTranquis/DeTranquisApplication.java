package com.TeamProject.deTranquis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(/* exclude = { SecurityAutoConfiguration.class } */)
public class DeTranquisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeTranquisApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
