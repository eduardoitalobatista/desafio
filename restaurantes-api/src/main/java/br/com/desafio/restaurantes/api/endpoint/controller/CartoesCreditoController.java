package br.com.desafio.restaurantes.api.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.restaurantes.api.endpoint.service.CartoesCreditoService;
import br.com.desafio.restaurantes.api.model.CartoesCredito;

/**
 * Controlador da API de CartoesCredito.
 *
 * @author  Eduardo Batista
 * @see     CartoesCreditoService
 * @see     CartoesCredito
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@RestController
@RequestMapping("/cartoes-credito")
public class CartoesCreditoController {
	
	@Autowired
	CartoesCreditoService cartoesCreditoService;
	
	@GetMapping
	public ResponseEntity<Iterable<CartoesCredito>> read(Pageable pageable){
		return new ResponseEntity<>(cartoesCreditoService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método POST.
	 *
	 * @param CartoesCredito
	 * @return ResponseEntity<CartoesCredito>
	 */
	@PostMapping
	public ResponseEntity<CartoesCredito> create(@RequestBody CartoesCredito cartoesCredito) {
		return new ResponseEntity<>(cartoesCreditoService.create(cartoesCredito), 
				HttpStatus.CREATED);
	}
	
}