package br.com.desafio.restaurantes.api.endpoint.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.api.model.Clientes;
import br.com.desafio.restaurantes.api.repository.ClientesRepository;
import br.com.desafio.restaurantes.api.repository.ItensPedidoRepository;

/**
 * Camada de Transação para Clientes.
 *
 * @author  Eduardo Batista
 * @see     Clientes
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Service
public class ClientesService {
	
	@Autowired
	ClientesRepository clientesRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@HystrixCommand(fallbackMethod = "defaultClientes")
	public Iterable<Clientes> read(Pageable pageable) {
		return clientesRepository.findAll(pageable);
	}
		
	/**
	 * Método de criação de um registro.
	 *
	 * @param Clientes
	 * @return Clientes
	 */	
	@Transactional
	public Clientes create(Clientes clientes) {
		Clientes clienteCriado = clientesRepository.save(clientes);
		return clienteCriado;
	}
	
	/**
	 * Método para edição de registro.
	 * @param id 
	 *
	 * @param Clientes
	 * @return Clientes
	 */	
	@Transactional
	public Clientes update(Long id, Clientes clientes) {
		Clientes clienteAtual = null;
		Optional<Clientes> optional = clientesRepository.findById(id);
		if (optional.isPresent()) {
			clienteAtual = optional.get();
			if (clientes.getNome() != null) {
				clienteAtual.setNome(clientes.getNome());
			}
			if (clientes.getEndereco() != null) {
				clienteAtual.setEndereco(clientes.getEndereco());
			}	
			if (clientes.getSenha() != null) {
				clienteAtual.setSenha(clientes.getSenha());
			}
			clienteAtual = clientesRepository.save(clienteAtual);
		}
		return clienteAtual;
	}
	
	/**
	 * Método que retorna nova instância de Clientes.
	 *	
	 * @return Clientes
	 */
	public Iterable<Clientes> defaultClientes(Pageable pageable) {
		Iterable<Clientes> defaultClientes = null;
		return defaultClientes;
	}

}