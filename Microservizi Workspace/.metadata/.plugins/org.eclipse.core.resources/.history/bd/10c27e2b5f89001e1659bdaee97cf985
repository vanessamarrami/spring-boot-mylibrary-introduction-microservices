package com.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/fallbackLibrary")
	public Mono<String> fallbackLibrary() {
	    return Mono.just("Servizio Library temporaneamente non disponibile.");
	}
}