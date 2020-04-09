package br.com.desafio.restaurantes.busca.tipos.comida.endpoint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.busca.tipos.comida.model.TiposComida;
import br.com.desafio.restaurantes.busca.tipos.comida.repository.BuscaTiposComidaRepository;

/**
 * Camada de Serviços para Tipos de Comida.
 *
 * @author  Eduardo Batista
 * @see     TiposComida
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */
@Service
public class BuscaTiposComidaService {
		
	@Autowired
	BuscaTiposComidaRepository buscaTiposComidaRepository;

	/**
	 * Método que retorna todos os registros.
	 *
	 * @return Iterable<TiposComida>
	 */
	@HystrixCommand(fallbackMethod = "defaultTiposComida")
	public Iterable<TiposComida> read(Pageable pageable) {
		return buscaTiposComidaRepository.findAll(pageable);
	}
	
	/**
	 * Método que retorna um registro pelo id.
	 *
	 * @param id
	 * @return Optional<TiposComida>
	 */
	public Optional<TiposComida> read(Long id) {
		return buscaTiposComidaRepository.findById(id);
	}
	
	/**
	 * Método que retorna registros pesquisados por nome.
	 *
	 * @param nome 
	 * @return Iterable<TiposComida>
	 */
	public Iterable<TiposComida> read(String nome, Pageable pageable) {
		return buscaTiposComidaRepository.findByTipoComidaContainsIgnoreCaseOrderByTipoComidaAsc(
				nome, pageable);
	}
	
	/**
	 * Método que retorna nova instância de TiposComida.
	 *	
	 * @return Iterable<TiposComida>
	 */
	public Iterable<TiposComida> defaultTiposComida(Pageable pageable) {
		Iterable<TiposComida> defaultTiposComida = null;
		return defaultTiposComida;
	}

}
