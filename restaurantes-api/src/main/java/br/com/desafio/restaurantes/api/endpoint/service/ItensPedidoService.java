package br.com.desafio.restaurantes.api.endpoint.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.api.model.ItensPedido;
import br.com.desafio.restaurantes.api.repository.ItensPedidoRepository;

/**
 * Camada de Transação para ItensPedido.
 *
 * @author  Eduardo Batista
 * @see     ItensPedido
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Service
public class ItensPedidoService {
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@HystrixCommand(fallbackMethod = "defaultItensPedido")
	public Iterable<ItensPedido> read(Pageable pageable) {
		return itensPedidoRepository.findAll(pageable);
	}
		
	/**
	 * Método de criação de um registro.
	 *
	 * @param ItensPedido
	 * @return ItensPedido
	 */	
	@Transactional
	public ItensPedido create(ItensPedido itensPedido) {
		ItensPedido itensPedidoCriado = itensPedidoRepository.save(itensPedido);
		return itensPedidoCriado;
	}
	
	/**
	 * Método que retorna nova instância de ItensPedido.
	 *	
	 * @return ItensPedido
	 */
	public Iterable<ItensPedido> defaultItensPedido(Pageable pageable) {
		Iterable<ItensPedido> defaultItensPedido = null;
		return defaultItensPedido;
	}

}