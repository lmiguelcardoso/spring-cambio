package com.springcambio.moedacotacaoservico.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name = "sample-api")
	public String sampleAPI() {
		logger.info("Sample API chamada recebida");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-shit" , String.class);
//		return forEntity.getBody();
		return "SampleAPI";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
