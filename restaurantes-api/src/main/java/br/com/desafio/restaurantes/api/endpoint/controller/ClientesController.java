package br.com.desafio.restaurantes.api.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.restaurantes.api.endpoint.service.ClientesService;
import br.com.desafio.restaurantes.api.model.Clientes;

/**
 * Controlador da API de Clientes.
 *
 * @author  Eduardo Batista
 * @see     ClientesService
 * @see     Clientes
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	ClientesService clientesService;
	
	@GetMapping
	public ResponseEntity<Iterable<Clientes>> read(Pageable pageable){
		return new ResponseEntity<>(clientesService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método POST.
	 *
	 * @param Clientes
	 * @return ResponseEntity<Clientes>
	 */
	@PostMapping
	public ResponseEntity<Clientes> create(@RequestBody Clientes clientes) {
		return new ResponseEntity<>(clientesService.create(clientes), HttpStatus.CREATED);
	}
	
	/**
	 * Método PUT.
	 *
	 * @param Clientes
	 * @return ResponseEntity<Clientes>
	 */
	@PutMapping("{id}")
	public ResponseEntity<Clientes> update(@PathVariable Long id, 
			@RequestBody Clientes clientes) {
		Clientes restauranteAtual = clientesService.update(id, clientes);
		ResponseEntity<Clientes> responseEntity;
		if (restauranteAtual != null) {
			responseEntity = new ResponseEntity<>(clientesService.update(id, clientes), 
					HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
}