package br.com.desafio.restaurantes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.restaurantes.api.model.Clientes;


/**
 * Repositório de Clientes.
 *
 * @author  Eduardo Batista
 * @see     Clientes
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
	
}
