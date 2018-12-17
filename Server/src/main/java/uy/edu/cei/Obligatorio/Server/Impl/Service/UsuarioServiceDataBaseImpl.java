package uy.edu.cei.Obligatorio.Server.Impl.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Service.JPAService;
import uy.edu.cei.Obligatorio.Server.Service.UsuarioService;

public class UsuarioServiceDataBaseImpl implements UsuarioService {
	private static UsuarioServiceDataBaseImpl instancia;
	public static UsuarioServiceDataBaseImpl getInstancia() {
		if(instancia==null) {
			instancia = new UsuarioServiceDataBaseImpl();
		}
		return instancia;
	}
	
	public UsuarioServiceDataBaseImpl() {
		
	}
	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException {
		EntityManager em = JPAService.getInstance().getEM();
		UsuarioModel usu = null;
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario",nombre);
		List<UsuarioModel> results = query.getResultList();
		if(!results.isEmpty())
			usu = query.getSingleResult();
		em.getTransaction().commit();
		return usu;
	}

	public UsuarioModel registrar(String nombre, String contra,int avatar) throws RemoteException {
		EntityManager em = JPAService.getInstance().getEM();
		UsuarioModel usu = null; // te cree la variable para que la puedas usar en la linea 44
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario",nombre);
		List<UsuarioModel> results = query.getResultList();
		if(results.isEmpty()) {
			usu = new UsuarioModel(nombre,contra,avatar);
			em.persist(usu);
		}
		em.getTransaction().commit();
		return usu; //aca iba return usuQuery;
	}

	public List<UsuarioModel> listaUsuarios() throws RemoteException {
		List<UsuarioModel> results;
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.todos",UsuarioModel.class);
		results = query.getResultList();
		em.getTransaction().commit();
		return results;
	}

	@Override
	public UsuarioModel buscarPorId(long id) throws RemoteException {
		EntityManager em = JPAService.getInstance().getEM();
		UsuarioModel usuario;
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.buscarPorId",UsuarioModel.class);
		query.setParameter("id",id);
		usuario = query.getSingleResult();
		em.getTransaction().commit();
		return usuario;
	}

	@Override
	public UsuarioModel modificar(Long idUsuario,String nombre, String contra, int avatar) throws RemoteException {
		EntityManager em = JPAService.getInstance().getEM();
		UsuarioModel usu = null;
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario",nombre);
		List<UsuarioModel> results = query.getResultList();
		if(results.isEmpty())
		{
			query = em.createNamedQuery("UsuarioModel.buscarPorId",UsuarioModel.class);
			query.setParameter("id",idUsuario);
			usu = query.getSingleResult();
			usu.SetUsuario(nombre);
			usu.SetContra(contra);
			usu.setAvatar(avatar);
			em.persist(usu);
		}
		em.getTransaction().commit();
		return usu;
	}

	@Override
	public List<UsuarioModel> listaVictorias() throws RemoteException {
		List<UsuarioModel> results;
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.victorias",UsuarioModel.class);
		results = query.getResultList();
		em.getTransaction().commit();
		return results;
	}

	@Override
	public List<UsuarioModel> listaPuntos() throws RemoteException {
		List<UsuarioModel> results;
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.puntos",UsuarioModel.class);
		results = query.getResultList();
		em.getTransaction().commit();
		return results;
	}

	@Override
	public List<UsuarioModel> listaReales() throws RemoteException {
		List<UsuarioModel> results;
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.reales",UsuarioModel.class);
		results = query.getResultList();
		em.getTransaction().commit();
		return results;
	}

	@Override
	public List<UsuarioModel> listaVirtuales() throws RemoteException {
		List<UsuarioModel> results;
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.virtuales",UsuarioModel.class);
		results = query.getResultList();
		em.getTransaction().commit();
		return results;
	}

}
