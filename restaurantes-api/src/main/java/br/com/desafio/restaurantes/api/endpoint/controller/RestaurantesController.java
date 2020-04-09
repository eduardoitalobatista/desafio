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

import br.com.desafio.restaurantes.api.endpoint.service.RestaurantesService;
import br.com.desafio.restaurantes.api.model.Restaurantes;

/**
 * Controlador da API de Restaurantes.
 *
 * @author  Eduardo Batista
 * @see     RestaurantesService
 * @see     Restaurantes
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {
	
	@Autowired
	RestaurantesService restaurantesService;
	
	@GetMapping
	public ResponseEntity<Iterable<Restaurantes>> read(Pageable pageable){
		return new ResponseEntity<>(restaurantesService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método POST.
	 *
	 * @param Restaurantes
	 * @return ResponseEntity<Restaurantes>
	 */
	@PostMapping
	public ResponseEntity<Restaurantes> create(@RequestBody Restaurantes restaurantes) {
		return new ResponseEntity<>(restaurantesService.create(restaurantes), HttpStatus.CREATED);
	}
	
	/**
	 * Método PUT.
	 *
	 * @param Restaurantes
	 * @return ResponseEntity<Restaurantes>
	 */
	@PutMapping("{id}")
	public ResponseEntity<Restaurantes> update(@PathVariable Long id, 
			@RequestBody Restaurantes restaurantes) {
		Restaurantes restauranteAtual = restaurantesService.update(id, restaurantes);
		ResponseEntity<Restaurantes> responseEntity;
		if (restauranteAtual != null) {
			responseEntity = new ResponseEntity<>(restaurantesService.update(id, restaurantes), 
					HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
}