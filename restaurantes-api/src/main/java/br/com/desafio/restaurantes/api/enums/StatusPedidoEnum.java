package br.com.desafio.restaurantes.api.enums;

public enum StatusPedidoEnum {
	
	ABERTO("A"),
	FECHADO("F"),
	PAGO("P");
	
	public String status;

	StatusPedidoEnum(String status) {
		this.status = status;
	}

}
