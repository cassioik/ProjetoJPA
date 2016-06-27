package com.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_id", updatable=false)
	private Integer id;
	@Column(name="tipo_id", nullable=false)
	private Integer tipoAnimalId;
	@Column(name="pessoa_id", nullable=false)
	private Integer donoId;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(nullable=true)
	private Date nascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer pId) {
		id = pId;
	}
	public Integer getTipoAnimalId() {
		return tipoAnimalId;
	}
	public void setTipoAnimalId(Integer pTipoAnimalId) {
		tipoAnimalId = pTipoAnimalId;
	}
	public Integer getDonoId() {
		return donoId;
	}
	public void setDonoId(Integer pDonoId) {
		donoId = pDonoId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String pNome) {
		nome = pNome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date pNascimento) {
		nascimento = pNascimento;
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
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
