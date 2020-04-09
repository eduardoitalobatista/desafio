package br.com.desafio.restaurantes.api.endpoint.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.api.model.Restaurantes;
import br.com.desafio.restaurantes.api.repository.ItensPedidoRepository;
import br.com.desafio.restaurantes.api.repository.RestaurantesRepository;

/**
 * Camada de Transação para Restaurantes.
 *
 * @author  Eduardo Batista
 * @see     Restaurantes
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Service
public class RestaurantesService {

	@Autowired
	RestaurantesRepository restaurantesRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@HystrixCommand(fallbackMethod = "defaultRestaurantes")
	public Iterable<Restaurantes> read(Pageable pageable) {
		return restaurantesRepository.findAll(pageable);
	}
		
	/**
	 * Método de criação de um registro.
	 *
	 * @param Restaurantes
	 * @return Restaurantes
	 */	
	@Transactional
	public Restaurantes create(Restaurantes restaurantes) {
		Restaurantes restauranteCriado = restaurantesRepository.save(restaurantes);
		return restauranteCriado;
	}
	
	/**
	 * Método para edição de registro.
	 * @param id 
	 *
	 * @param Restaurantes
	 * @return Restaurantes
	 */	
	@Transactional
	public Restaurantes update(Long id, Restaurantes restaurantes) {
		Restaurantes restauranteAtual = null;
		Optional<Restaurantes> optional = restaurantesRepository.findById(id);
		if (optional.isPresent()) {
			restauranteAtual = optional.get();
			if (restaurantes.getNome() != null) {
				restauranteAtual.setNome(restaurantes.getNome());
			}
			if (restaurantes.getTiposComida() != null) {
				restauranteAtual.setTiposComida(restaurantes.getTiposComida());
			}			
			restauranteAtual = restaurantesRepository.save(restauranteAtual);
		}
		return restauranteAtual;
	}
	
	/**
	 * Método que retorna nova instância de Restaurantes.
	 *	
	 * @return Restaurantes
	 */
	public Iterable<Restaurantes> defaultRestaurantes(Pageable pageable) {
		Iterable<Restaurantes> defaultRestaurantes = null;
		return defaultRestaurantes;
	}

}