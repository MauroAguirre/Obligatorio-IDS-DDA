package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.UsuarioService;

public class UsuarioServiceDataBaseImpl implements UsuarioService {
	private static UsuarioServiceDataBaseImpl instancia;
	private static EntityManager entityManager;
	public static UsuarioServiceDataBaseImpl getInstancia(EntityManager em) {
		if(instancia==null) {
			instancia = new UsuarioServiceDataBaseImpl();
			entityManager = em;
		}
		return instancia;
	}
	@Override
	public Map<String, UsuarioModel> ListaUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException {
		entityManager.getTransaction().begin();
		TypedQuery<UsuarioModel> query = entityManager.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario",nombre);
		UsuarioModel usuQuery = query.getSingleResult();
		entityManager.getTransaction().commit();
		return usuQuery;
	}

}
