package br.com.desafio.restaurantes.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7278903684070554563L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valorTotal;
	
	@Column(length = 1)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Clientes clientes;
	
	@ManyToOne
	@JoinColumn(name = "forma_pagamento")
	private FormasPagamento formasPagamento;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the clientes
	 */
	public Clientes getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the formasPagamento
	 */
	public FormasPagamento getFormasPagamento() {
		return formasPagamento;
	}

	/**
	 * @param formasPagamento the formasPagamento to set
	 */
	public void setFormasPagamento(FormasPagamento formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}