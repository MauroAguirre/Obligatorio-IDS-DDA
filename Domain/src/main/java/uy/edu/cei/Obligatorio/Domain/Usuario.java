package uy.edu.cei.Obligatorio.Domain;

public class Usuario {
	private String usuario;
	private String contra;
	
	public Usuario(String usuario,String contra) {
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
