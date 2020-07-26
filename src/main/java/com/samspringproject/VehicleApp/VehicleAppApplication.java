package com.samspringproject.VehicleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class VehicleAppApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SpringSecurityAuditableAware();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleAppApplication.class, args);
	}

}
 