package com.clinicaveterinaria.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VacinaAnimal")
public class VacinaAnimal {
	@EmbeddedId
	private VacinaAnimalID id;
	
	private String descricaoVeterinario;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id", insertable = false, updatable = false)
	private Vacina vacina;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", insertable = false, updatable = false)
	private Animal animal;

	public VacinaAnimalID getId() {
		return id;
	}

	public void setId(VacinaAnimalID id) {
		this.id = id;
	}

	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}

	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal pAnimal) {
		animal = pAnimal;
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
		VacinaAnimal other = (VacinaAnimal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
