package br.com.desafio.restaurantes.busca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.desafio.restaurantes.busca.model.Restaurantes;

/**
 * Repositório para Restaurantes.
 *
 * @author  Eduardo Batista
 * @see     Restaurantes
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */
public interface BuscaRestaurantesRepository extends PagingAndSortingRepository<Restaurantes, Long> {
	
	Page<Restaurantes> findByNomeContainsIgnoreCaseOrderByNomeAsc(String nome, Pageable pageable);
	
	Page<Restaurantes> findByLatitudeAndLongitude(String latitude, String longitude, Pageable pageable);

}
