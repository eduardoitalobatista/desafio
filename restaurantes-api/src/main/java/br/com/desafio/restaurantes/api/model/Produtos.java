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
@Table(name = "produtos")
public class Produtos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2712342970609014158L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String produto;
	
	@Column(length = 160)
	private String descricao;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categorias categorias;
	
	@ManyToOne
	@JoinColumn(name = "restaurante")
	private Restaurantes restaurantes;
	
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
	 * @return the produto
	 */
	public String getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(String produto) {
		this.produto = produto;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the categorias
	 */
	public Categorias getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the restaurantes
	 */
	public Restaurantes getRestaurantes() {
		return restaurantes;
	}

	/**
	 * @param restaurantes the restaurantes to set
	 */
	public void setRestaurantes(Restaurantes restaurantes) {
		this.restaurantes = restaurantes;
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
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
