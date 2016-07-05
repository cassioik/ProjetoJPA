package com.clinicaveterinaria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_id", updatable=false)
	private Integer id;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(nullable=true)
	private Date nascimento;
	
	@ManyToOne
	@JoinColumn(name="tipoanimal_id", nullable=false)
	private TipoAnimal tipo;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable=false)
	private Pessoa dono;
	
	@OneToMany(mappedBy="id.idAnimal", fetch=FetchType.EAGER)
	private Set<VacinaAnimal> vacinasAnimal;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable (
		name="alergiaanimal", 
		joinColumns={@JoinColumn(name="animal_id", referencedColumnName="animal_id")},
		inverseJoinColumns={@JoinColumn(name="alergia_id", referencedColumnName="alergia_id")}
	)
	private Set<Alergia> alergia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoAnimal getTipo() {
		return tipo;
	}
	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}
	public Pessoa getDono() {
		return dono;
	}
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Set<Alergia> getAlergia() {
		return alergia;
	}
	public void setAlergia(Set<Alergia> alergia) {
		this.alergia = alergia;
	}
	public Set<VacinaAnimal> getVacinasAnimal() {
		return vacinasAnimal;
	}
	public void setVacinasAnimal(Set<VacinaAnimal> vacinasAnimal) {
		this.vacinasAnimal = vacinasAnimal;
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
