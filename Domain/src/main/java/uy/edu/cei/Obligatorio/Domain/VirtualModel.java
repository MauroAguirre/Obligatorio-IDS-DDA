package uy.edu.cei.Obligatorio.Domain;

import java.io.Serializable;
import java.rmi.Remote;

public class VirtualModel implements SalaModel, Remote, Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private UsuarioModel player1;
	private UsuarioModel player2;
	private int apuesta;
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public UsuarioModel getPlayer1() {
		return this.player1;
	}

	@Override
	public UsuarioModel getPlayer2() {
		return this.player2;
	}

	@Override
	public void setPlayer1(UsuarioModel player) {
		this.player1 = player;
	}

	@Override
	public void setPlayer2(UsuarioModel player) {
		this.player2 = player;
	}

	@Override
	public int getApuesta() {
		return this.apuesta;
	}

	@Override
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}


}
