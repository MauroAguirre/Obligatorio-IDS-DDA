package uy.edu.cei.Obligatorio.Server;

import java.util.ArrayList;
import java.util.List;
import uy.edu.cei.Obligatorio.Domain.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	private static UsuarioServiceImpl instancia;
	private static List<Usuario> usuarios;
	
	public static UsuarioServiceImpl Instancia() {
		if(instancia == null) {
			instancia = new UsuarioServiceImpl();
		}		
		return instancia;
	}
	@Override
	public List<Usuario> ListaUsuarios() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("mauro","123"));
		System.out.println(usuarios.get(0).GetContra());
		return usuarios;
	}
	public String Hola() {
		// TODO Auto-generated method stub
		return null;
	}
}
