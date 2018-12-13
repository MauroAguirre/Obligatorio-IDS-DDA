package uy.edu.cei.Obligatorio.Server.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uy.edu.cei.Obligatorio.Domain.RegistroModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class JPAService {

	private static final JPAService instance = new JPAService();

	public static JPAService getInstance() {
		return JPAService.instance;
	}

	private EntityManager entityManager;

	private JPAService() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDS");
		this.entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		UsuarioModel u2 = new UsuarioModel("matias","123",3);
		UsuarioModel u = new UsuarioModel("mauro","123",2);
		entityManager.persist(u);
		entityManager.persist(u2);
		entityManager.getTransaction().commit();
	}

	public EntityManager getEM() {
		return this.entityManager;
	}
}
