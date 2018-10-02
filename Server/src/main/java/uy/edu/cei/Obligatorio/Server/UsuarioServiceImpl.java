package uy.edu.cei.Obligatorio.Server;

import java.util.ArrayList;
import java.util.List;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class UsuarioServiceImpl implements UsuarioService{
	private static UsuarioServiceImpl instancia;
	private static List<UsuarioModel> usuarios;
	
	public static UsuarioServiceImpl Instancia() {
		if(instancia == null) {
			instancia = new UsuarioServiceImpl();
		}		
		return instancia;
	}
	@Override
	public List<UsuarioModel> ListaUsuarios() {
		usuarios = new ArrayList<UsuarioModel>();
		usuarios.add(new UsuarioModel("mauro","123"));
		System.out.println(usuarios.get(0).GetContra());
		return usuarios;
	}
	public String Hola() {
		// TODO Auto-generated method stub
		return null;
	}
}
