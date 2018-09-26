package uy.edu.cei.Obligatorio.Server;

import java.util.List;

import uy.edu.cei.Obligatorio.Common.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.Usuario;

public class UsuarioControllerImpl implements UsuarioController {
	private static UsuarioControllerImpl instancia;
	private UsuarioService usuarioService;
	
	public static UsuarioControllerImpl Instancia() {
		if(instancia == null)
			instancia = new UsuarioControllerImpl();
		return instancia;
	}
	
	private UsuarioControllerImpl() {
		this.usuarioService = UsuarioServiceImpl.Instancia();
	}
	
	@Override
	public List<Usuario> ListaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	public String Hola() {
		return this.usuarioService.Hola();
	}
}
