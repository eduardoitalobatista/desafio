package br.com.desafio.restaurantes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.restaurantes.api.model.ItensPedido;


/**
 * Repositório de Pedidos.
 *
 * @author  Eduardo Batista
 * @see     ItensPedido
 * @since   1.0.0
 * @version 1.0.0, 09 Abr 2020
 */

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
	
	List<ItensPedido> findByPedidosId(Long pedidosId);
	
}
