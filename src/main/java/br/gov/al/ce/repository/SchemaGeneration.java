package br.gov.al.ce.repository;

import br.gov.al.ce.model.Empresa;

import java.util.List;

import javax.inject.Inject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SchemaGeneration {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso-jsf");

		EntityManager em = emf.createEntityManager();
		
		
		
		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}
}
