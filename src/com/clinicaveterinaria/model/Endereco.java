package com.clinicaveterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="endereco_id", updatable=false)
	private Integer id;
	private String Rua;
	private Integer Cep;
	private Integer Numero;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id") 
	private Pessoa pessoa;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer pId) {
		id = pId;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pPessoa) {
		pessoa = pPessoa;
	}
	public Integer getCep() {
		return Cep;
	}
	public void setCep(Integer pCep) {
		Cep = pCep;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer pNumero) {
		Numero = pNumero;
	}
	public String getRua() {
		return Rua;
	}
	public void setRua(String pRua) {
		Rua = pRua;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
