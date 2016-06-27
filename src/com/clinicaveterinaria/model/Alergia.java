package com.clinicaveterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALERGIA")
public class Alergia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alergia_id", updatable=false)
	private Integer id;
	@Column(name="nomealergia", nullable=false, length=45)
	private String nome;
	@Column(nullable=false, length=200)
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer pId) {
		id = pId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String pNome) {
		nome = pNome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String pDescricao) {
		descricao = pDescricao;
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
		Alergia other = (Alergia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
