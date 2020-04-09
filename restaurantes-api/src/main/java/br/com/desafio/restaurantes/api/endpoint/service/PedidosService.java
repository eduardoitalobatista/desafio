package br.com.desafio.restaurantes.api.endpoint.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.restaurantes.api.enums.StatusPedidoEnum;
import br.com.desafio.restaurantes.api.model.ItensPedido;
import br.com.desafio.restaurantes.api.model.Pedidos;
import br.com.desafio.restaurantes.api.model.Produtos;
import br.com.desafio.restaurantes.api.repository.ItensPedidoRepository;
import br.com.desafio.restaurantes.api.repository.PedidosRepository;

/**
 * Camada de Transação para Pedidos.
 *
 * @author  Eduardo Batista
 * @see     Pedidos
 * @since   1.0.0
 * @version 1.0.0, 03 Abr 2020
 */

@Service
public class PedidosService {
	
	@Autowired
	PedidosRepository pedidosRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@HystrixCommand(fallbackMethod = "defaultPedidos")
	public Iterable<Pedidos> read(Pageable pageable) {
		return pedidosRepository.findAll(pageable);
	}
		
	/**
	 * Método de criação de um registro.
	 *
	 * @param Pedidos
	 * @return Pedidos
	 */	
	@Transactional
	public Pedidos create(Pedidos pedidos) {
		pedidos.setStatus(StatusPedidoEnum.ABERTO.status);
		Pedidos pedidoCriado = pedidosRepository.save(pedidos);
		return pedidoCriado;
	}
	
	/**
	 * Método de fechamento do pedido.
	 *
	 * @param Pedidos pedidos
	 * @return Pedidos
	 */	
	@Transactional
	public Pedidos fechamento(Pedidos pedidos) {
		BigDecimal total = new BigDecimal(NumberUtils.INTEGER_ZERO);
		Optional<Pedidos> pedidosOptional = pedidosRepository.findById(pedidos.getId());
		if (pedidosOptional.isPresent()) {
			pedidos = pedidosOptional.get();
			List<ItensPedido> itensPedidoList = itensPedidoRepository.findByPedidosId(pedidos.
					getId());
			if (!itensPedidoList.isEmpty()) {
				total = calculaTotal(itensPedidoList);
			}	
			pedidos.setValorTotal(total);
			pedidos.setStatus(StatusPedidoEnum.FECHADO.status);
			pedidos = pedidosRepository.save(pedidos);
		}
		return pedidos;
	}
	
	/**
	 * Método de pagamento do pedido.
	 *
	 * @param Pedidos pedidos
	 * @return Pedidos
	 */	
	@Transactional
	public Pedidos pagamento(Pedidos pedidoAlterado) {
		Pedidos pedidos = new Pedidos();
		Optional<Pedidos> pedidosOptional = pedidosRepository.findById(pedidoAlterado.getId());
		if (pedidosOptional.isPresent()) {
			pedidos = pedidosOptional.get();
			pedidos.setStatus(StatusPedidoEnum.PAGO.status);
			pedidos.setFormasPagamento(pedidoAlterado.getFormasPagamento());
			pedidos = pedidosRepository.save(pedidos);
		}
		return pedidos;
	}

	/**
	 * Método para cálculo do valor total dos itens do pedido.
	 * 
	 * @param itensPedidoList
	 * @return BigDecimal total
	 */
	private BigDecimal calculaTotal(List<ItensPedido> itensPedidoList) {
		BigDecimal total = new BigDecimal(NumberUtils.INTEGER_ZERO);
		BigDecimal valorProduto;
		BigDecimal totalPedido;
		Produtos produtos;
		for (ItensPedido itensPedido : itensPedidoList) {
			totalPedido = new BigDecimal(NumberUtils.INTEGER_ZERO);
			if (itensPedido.getProdutos() != null) {
				produtos = itensPedido.getProdutos();
				valorProduto = produtos.getValor();
				totalPedido = valorProduto.multiply(new BigDecimal(itensPedido
						.getQuantidade()));
				total = total.add(totalPedido);
			}
		}
		return total;
	}
	
	/**
	 * Método que retorna nova instância de Pedidos.
	 *	
	 * @return Pedidos
	 */
	public Iterable<Pedidos> defaultPedidos(Pageable pageable) {
		Iterable<Pedidos> defaultPedidos = null;
		return defaultPedidos;
	}

}