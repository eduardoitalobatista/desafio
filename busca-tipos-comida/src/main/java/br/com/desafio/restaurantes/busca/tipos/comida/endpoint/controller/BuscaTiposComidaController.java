package br.com.desafio.restaurantes.busca.tipos.comida.endpoint.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.restaurantes.busca.tipos.comida.endpoint.service.BuscaTiposComidaService;
import br.com.desafio.restaurantes.busca.tipos.comida.model.TiposComida;

/**
 * Controlador do microserviço de TiposComida.
 *
 * @author  Eduardo Batista
 * @see     BuscaTiposComidaService
 * @see     TiposComida
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */

@RestController
@RequestMapping("/")
public class BuscaTiposComidaController {
	
	@Autowired
	private BuscaTiposComidaService buscaTiposComidaServiceImpl;
	
	@Autowired
	BuscaTiposComidaService buscaTiposComidaService;
	
	/**
	 * Método GET.
	 *
	 * @return ResponseEntity<Iterable<TiposComida>>
	 */
	@GetMapping
	public ResponseEntity<Iterable<TiposComida>> read(Pageable pageable) {
		return new ResponseEntity<>(buscaTiposComidaServiceImpl.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método GET.
	 * @param id 
	 *
	 * @return ResponseEntity<Optional<TiposComida>>
	 */
	@GetMapping("{id}")
	public ResponseEntity<Optional<TiposComida>> read(@PathVariable Long id) {
		return new ResponseEntity<>(buscaTiposComidaServiceImpl.read(id), HttpStatus.OK);
	}
	
	/**
	 * Método GET.
	 *
	 * @param String nome
	 * @return ResponseEntity<Iterable<TiposComida>>
	 */
	@GetMapping("/por-nome")
	public ResponseEntity<Iterable<TiposComida>> read(Pageable pageable, 
			@RequestParam String nome) {
		return new ResponseEntity<>(buscaTiposComidaServiceImpl.read(nome, pageable), 
				HttpStatus.OK);
	}

}
