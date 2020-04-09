package br.com.desafio.restaurantes.busca.tipos.comida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class BuscaTiposComidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscaTiposComidaApplication.class, args);
	}
	
	/**
	 * Método que retorna nova instância de RestTemplate.
	 *	
	 * @return RestTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	

}
