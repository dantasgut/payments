package br.com.lab.payments.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.lab.payments.repositories.interfaces")
@ComponentScan({
		"br.com.lab.payments.api.services",
		"br.com.lab.payments.services"
		})
@EntityScan("br.com.lab.payments.repositories.entities")
public class PaymentConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
