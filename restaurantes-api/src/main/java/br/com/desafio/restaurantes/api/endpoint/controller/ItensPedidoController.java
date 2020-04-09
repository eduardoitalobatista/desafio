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

import br.com.desafio.restaurantes.api.endpoint.service.ItensPedidoService;
import br.com.desafio.restaurantes.api.model.ItensPedido;

/**
 * Controlador da API de ItensPedido.
 *
 * @author  Eduardo Batista
 * @see     ItensPedidoService
 * @see     ItensPedido
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@RestController
@RequestMapping("/itens-pedido")
public class ItensPedidoController {
	
	@Autowired
	ItensPedidoService itensPedidoService;
	
	@GetMapping
	public ResponseEntity<Iterable<ItensPedido>> read(Pageable pageable){
		return new ResponseEntity<>(itensPedidoService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método POST.
	 *
	 * @param ItensPedido
	 * @return ResponseEntity<ItensPedido>
	 */
	@PostMapping
	public ResponseEntity<ItensPedido> create(@RequestBody ItensPedido itensPedido) {
		return new ResponseEntity<>(itensPedidoService.create(itensPedido), HttpStatus.CREATED);
	}

}