package br.com.desafio.restaurantes.busca.tipos.comida.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.desafio.restaurantes.busca.tipos.comida.model.TiposComida;

/**
 * Repositório para Tipos de Comida.
 *
 * @author  Eduardo Batista
 * @see     TiposComida
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */
public interface BuscaTiposComidaRepository extends PagingAndSortingRepository<TiposComida, Long> {
	
	Page<TiposComida> findByTipoComidaContainsIgnoreCaseOrderByTipoComidaAsc(String nome, Pageable pageable);

}
