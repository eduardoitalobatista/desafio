package br.com.desafio.restaurantes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.restaurantes.api.model.CartoesCredito;


/**
 * Repositório de CartoesCredito.
 *
 * @author  Eduardo Batista
 * @see     CartoesCredito
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Repository
public interface CartoesCreditoRepository extends JpaRepository<CartoesCredito, Long> {
	
}
