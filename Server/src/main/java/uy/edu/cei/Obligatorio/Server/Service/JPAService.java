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
		UsuarioModel u1 = new UsuarioModel("matias","123",3,20,2000,2000,2000);
		UsuarioModel u2 = new UsuarioModel("mauro","123",1,30,1300,3000,1700);
		UsuarioModel u3 = new UsuarioModel("roberto","123",5,33,1300,500,90);
		UsuarioModel u4 = new UsuarioModel("paula","123",2,2,600,200,2200);
		UsuarioModel u5 = new UsuarioModel("nati","123",5,43,800,200,23);
		UsuarioModel u6 = new UsuarioModel("larala","123",4,1,7000,7760,20);
		entityManager.persist(u1);
		entityManager.persist(u2);
		entityManager.persist(u3);
		entityManager.persist(u4);
		entityManager.persist(u5);
		entityManager.persist(u6);
		entityManager.getTransaction().commit();
	}

	public EntityManager getEM() {
		return this.entityManager;
	}
}
