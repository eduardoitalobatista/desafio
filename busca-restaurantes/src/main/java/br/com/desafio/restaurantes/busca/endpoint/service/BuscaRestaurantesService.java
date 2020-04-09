package br.com.desafio.restaurantes.busca.endpoint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.busca.model.Restaurantes;
import br.com.desafio.restaurantes.busca.repository.BuscaRestaurantesRepository;

/**
 * Camada de Serviços para Restaurantes.
 *
 * @author  Eduardo Batista
 * @see     Restaurantes
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */
@Service
public class BuscaRestaurantesService {
	
	@Autowired
	BuscaRestaurantesRepository buscaRestaurantesRepository;
	
	/**
	 * Método que retorna todos os registros.
	 *
	 * @return Iterable<Restaurantes>
	 */
	@HystrixCommand(fallbackMethod = "defaultRestaurantes")
	public Iterable<Restaurantes> read(Pageable pageable) {
		return buscaRestaurantesRepository.findAll(pageable);
	}
	
	/**
	 * Método que retorna um registro pelo id.
	 * @param id 
	 *
	 * @return Optional<Restaurantes>
	 */
	public Optional<Restaurantes> read(Long id) {
		return buscaRestaurantesRepository.findById(id);
	}
	
	/**
	 * Método que retorna registros por nome.
	 * @param String nome 
	 *
	 * @return Iterable<Restaurantes>
	 */
	public Iterable<Restaurantes> read(String nome, Pageable pageable) {
		return buscaRestaurantesRepository.findByNomeContainsIgnoreCaseOrderByNomeAsc(nome, 
				pageable);
	}
	
	/**
	 * Método que retorna registro por latituide e longitude.
	 * @param latitude 
	 * @param longitude 
	 * @param pageable 
	 *
	 * @return Iterable<Restaurantes>
	 */
	public Iterable<Restaurantes> read(String latitude, String longitude, Pageable pageable) {
		return buscaRestaurantesRepository.findByLatitudeAndLongitude(latitude, longitude, 
				pageable);
	}
	
	/**
	 * Método que retorna nova instância de Restaurantes.
	 *	
	 * @return Iterable<Restaurantes>
	 */
	public Iterable<Restaurantes> defaultRestaurantes(Pageable pageable) {
		Iterable<Restaurantes> defaultRestaurantes = null;
		return defaultRestaurantes;
	}

}
