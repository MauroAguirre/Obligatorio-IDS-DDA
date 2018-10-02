package uy.edu.cei.Obligatorio.Domain;

public class UsuarioModel {
	private String usuario;
	private String contra;
	
	public UsuarioModel(String usuario,String contra) {
		this.usuario = usuario;
		this.contra = contra;
	}
	
	public void SetUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String GetUsuario() {
		return this.usuario;
	}
	
	public void SetContra(String contra) {
		this.contra = contra;
	}
	public String GetContra() {
		return this.contra;
	}
}
