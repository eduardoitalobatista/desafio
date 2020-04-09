package br.com.desafio.restaurantes.api.endpoint.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.api.model.CartoesCredito;
import br.com.desafio.restaurantes.api.repository.CartoesCreditoRepository;
import br.com.desafio.restaurantes.api.repository.ItensPedidoRepository;

/**
 * Camada de Transação para CartoesCredito.
 *
 * @author  Eduardo Batista
 * @see     CartoesCredito
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Service
public class CartoesCreditoService {
	
	@Autowired
	CartoesCreditoRepository cartoesCreditoRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@HystrixCommand(fallbackMethod = "defaultCartoesCredito")
	public Iterable<CartoesCredito> read(Pageable pageable) {
		return cartoesCreditoRepository.findAll(pageable);
	}
		
	/**
	 * Método de criação de um registro.
	 *
	 * @param CartoesCredito
	 * @return CartoesCredito
	 */	
	@Transactional
	public CartoesCredito create(CartoesCredito cartoesCredito) {
		CartoesCredito cartoesCreditoCriado = cartoesCreditoRepository.save(cartoesCredito);
		return cartoesCreditoCriado;
	}
	
	/**
	 * Método que retorna nova instância de CartoesCredito.
	 *	
	 * @return CartoesCredito
	 */
	public Iterable<CartoesCredito> defaultCartoesCredito(Pageable pageable) {
		Iterable<CartoesCredito> defaultCartoesCredito = null;
		return defaultCartoesCredito;
	}

}