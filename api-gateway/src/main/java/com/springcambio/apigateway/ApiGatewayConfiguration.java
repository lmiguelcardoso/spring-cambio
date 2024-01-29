package com.springcambio.apigateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/moeda-conversao/**")
						.uri("lb://moeda-conversor")
					)
				.route(p -> p
							.path("/moeda-cotacao/**")
							.uri("lb://moeda-cotacao-servico")
						)
				
				.build();
	}
}
