package uy.edu.cei.Obligatorio.Domain;

import java.io.Serializable;
import java.rmi.Remote;

public interface SalaModel extends Remote, Serializable {
	public String getNombre();
	public void setNombre(String nombre);
	public UsuarioModel getPlayer1();
	public UsuarioModel getPlayer2();
	public void setPlayer1(UsuarioModel player);
	public void setPlayer2(UsuarioModel player);
	public int getApuesta();
	public void setApuesta(int apuesta);
}
