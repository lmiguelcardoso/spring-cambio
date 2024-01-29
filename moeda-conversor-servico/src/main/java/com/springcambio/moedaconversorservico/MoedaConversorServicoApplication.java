package com.springcambio.moedaconversorservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication
@EnableFeignClients
public class MoedaConversorServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoedaConversorServicoApplication.class, args);
	}

	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}
}

