package com.clinicaveterinaria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VACINA")
public class Vacina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vacina_id", updatable=false)
	private Integer id;
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=true, length=100)
	private String descricao;
	
	@OneToMany(mappedBy="id.idVacina")
	private Set<VacinaAnimal> vacinasAnimal;
	
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
	public Set<VacinaAnimal> getVacinasAnimal() {
		return vacinasAnimal;
	}
	public void setVacinasAnimal(Set<VacinaAnimal> pVacinasAnimal) {
		vacinasAnimal = pVacinasAnimal;
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
		Vacina other = (Vacina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
