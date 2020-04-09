package br.com.desafio.restaurantes.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurantes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388296336579962339L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "tipoComida")
	private TiposComida tiposComida;
	
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the tiposComida
	 */
	public TiposComida getTiposComida() {
		return tiposComida;
	}
	
	/**
	 * @param tiposComida the tiposComida to set
	 */
	public void setTiposComida(TiposComida tiposComida) {
		this.tiposComida = tiposComida;
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
		Restaurantes other = (Restaurantes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
