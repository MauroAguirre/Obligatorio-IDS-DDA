package uy.edu.cei.Obligatorio.Client.Controller;

import java.util.List;

import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class RegistryController {
	private static RegistryController instancia;
	private static RegistryPanel panel;
	
	public static RegistryController getInstancia() {
		if(instancia == null) {
			instancia = new RegistryController();
			panel = new RegistryPanel();
		}
		return instancia;
	}
	public UsuarioModel agregarUsuario(String usuario,String contra,int avatar) {
		return null;
	}
	public List<UsuarioModel> listarUsuarios(){
		return null;
	}
	public UsuarioModel modificarUsuario(String usuario,String contra,int avatar) {
		return null;
	}
}
