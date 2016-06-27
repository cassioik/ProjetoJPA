package com.clinicaveterinaria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal {
	private Integer id;
	private Integer tipoAnimalId;
	private Integer donoId;
	private String nome;
	private Date nascimento;
}
