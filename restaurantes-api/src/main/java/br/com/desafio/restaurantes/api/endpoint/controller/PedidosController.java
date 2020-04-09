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

import br.com.desafio.restaurantes.api.endpoint.service.PedidosService;
import br.com.desafio.restaurantes.api.model.Pedidos;

/**
 * Controlador da API de Pedidos.
 *
 * @author  Eduardo Batista
 * @see     PedidosService
 * @see     Pedidos
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	PedidosService pedidosService;
	
	@GetMapping
	public ResponseEntity<Iterable<Pedidos>> read(Pageable pageable){
		return new ResponseEntity<>(pedidosService.read(pageable), HttpStatus.OK);
	}
	
	/**
	 * Método POST.
	 *
	 * @param Pedidos
	 * @return ResponseEntity<Pedidos>
	 */
	@PostMapping
	public ResponseEntity<Pedidos> create(@RequestBody Pedidos pedidos) {
		return new ResponseEntity<>(pedidosService.create(pedidos), HttpStatus.CREATED);
	}
	
	/**
	 * Método POST apenas para fechamento do pedido.
	 *
	 * @param Pedidos
	 * @return ResponseEntity<Pedidos>
	 */
	@PostMapping("/fechamento")
	public ResponseEntity<Pedidos> fechamento(@RequestBody Pedidos pedidos) {
		return new ResponseEntity<>(pedidosService.fechamento(pedidos), HttpStatus.CREATED);
	}
	
	/**
	 * Método POST apenas para pagamento do pedido.
	 *
	 * @param Pedidos
	 * @return ResponseEntity<Pedidos>
	 */
	@PostMapping("/pagamento")
	public ResponseEntity<Pedidos> pagamento(@RequestBody Pedidos pedidos) {
		return new ResponseEntity<>(pedidosService.pagamento(pedidos), HttpStatus.CREATED);
	}

}