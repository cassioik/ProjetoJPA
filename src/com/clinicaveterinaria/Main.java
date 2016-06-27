package com.clinicaveterinaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.clinicaveterinaria.model.Alergia;
import com.clinicaveterinaria.model.Animal;
import com.clinicaveterinaria.model.Pessoa;
import com.clinicaveterinaria.model.TipoAnimal;
import com.clinicaveterinaria.model.Vacina;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager em = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("clinica_pu");
			em = factory.createEntityManager();
			
			Pessoa pessoa = null;
			Animal animal = null;
			TipoAnimal tipoAnimal = null;
			Vacina vacina = null;
			Alergia alergia = null;
			
			em.getTransaction().begin();
//			pessoa = em.find(Pessoa.class, 2);
//			pessoa.setNome("C�ssio");
//			animal = em.find(Animal.class, 2);
//			tipoAnimal = em.find(TipoAnimal.class, 1);
//			vacina = em.find(Vacina.class, 1);
			alergia = em.find(Alergia.class, 1);
			em.getTransaction().commit();
			
			System.out.println(alergia.getNome());
			
		} catch (Exception e) {
			if(em!=null && em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if(em!=null)
				em.close();
			if(factory!=null)
				factory.close();
		}
	}
}
