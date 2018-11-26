package uy.edu.cei.Obligatorio.Server;

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
		UsuarioModel u2 = new UsuarioModel("matias","123");
		UsuarioModel u = new UsuarioModel("mauro","123");
		RegistroModel r1 = new RegistroModel("kakaroto");
		RegistroModel r2 = new RegistroModel("ponele sabor");
		entityManager.persist(u);
		entityManager.persist(u2);
		u.getRegistros().add(r1);
		u.getRegistros().add(r2);
		entityManager.getTransaction().commit();
	}

	public EntityManager getEM() {
		return this.entityManager;
	}
}
