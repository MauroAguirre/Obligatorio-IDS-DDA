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
		EntityManager em = JPAService.getInstance().getEM();
		em.getTransaction().begin();
		//em.ge
		em.getTransaction().commit();
		return null;
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
	public UsuarioModel modificar(String nombre, String contra, int avatar) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
