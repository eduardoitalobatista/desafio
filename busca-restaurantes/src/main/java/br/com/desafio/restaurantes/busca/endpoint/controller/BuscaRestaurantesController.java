package br.com.desafio.restaurantes.busca.endpoint.controller;

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

import br.com.desafio.restaurantes.busca.endpoint.service.BuscaRestaurantesService;
import br.com.desafio.restaurantes.busca.model.Restaurantes;

/**
 * Controlador do microserviço de Restaurantes.
 *
 * @author  Eduardo Batista
 * @see     BuscaRestaurantesService
 * @see     Restaurantes
 * @since   1.0.0
 * @version 1.0.0, 07 Abr 2020
 */
@RestController
@RequestMapping("/")
public class BuscaRestaurantesController {
	
	@Autowired
	BuscaRestaurantesService buscaRestaurantesService;
	
	/**
	 * Método GET.
	 *
	 * @return ResponseEntity<Iterable<Restaurantes>>
	 */
	@GetMapping
	public ResponseEntity<Iterable<Restaurantes>> read(Pageable pageable){
		return new ResponseEntity<>(buscaRestaurantesService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método GET.
	 * @param id 
	 *
	 * @return ResponseEntity<Optional<Restaurantes>>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Restaurantes>> read(@PathVariable Long id){
		return new ResponseEntity<>(buscaRestaurantesService.read(id), HttpStatus.OK);
	}
	
	/**
	 * Método GET.
	 * @param pageable 
	 * @param nome 
	 *
	 * @return ResponseEntity<Iterable<Restaurantes>>
	 */
	@GetMapping("/por-nome")
	public ResponseEntity<Iterable<Restaurantes>> read(@RequestParam String nome, 
			Pageable pageable){
		return new ResponseEntity<>(buscaRestaurantesService.read(nome, pageable), HttpStatus.OK);
	}
	
	/**
	 * Método GET.
	 * @param latitude 
	 * @param longitude 
	 * @param pageable 
	 *
	 * @return ResponseEntity<Iterable<Restaurantes>>
	 */
	@GetMapping("/por-latitude-longitude")
	public ResponseEntity<Iterable<Restaurantes>> read(@RequestParam String latitude, 
			@RequestParam String longitude, Pageable pageable){
		return new ResponseEntity<>(buscaRestaurantesService.read(latitude, longitude, pageable),
				HttpStatus.OK);
	}

}
