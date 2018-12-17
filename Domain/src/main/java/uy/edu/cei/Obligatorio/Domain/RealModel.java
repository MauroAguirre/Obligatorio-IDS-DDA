package uy.edu.cei.Obligatorio.Domain;

import java.io.Serializable;
import java.rmi.Remote;

public class RealModel implements SalaModel, Remote, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private UsuarioModel player1;
	private UsuarioModel player2;
	private int apuesta;
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UsuarioModel getPlayer1() {
		return this.player1;
	}
	public UsuarioModel getPlayer2() {
		return this.player2;
	}
	public void setPlayer1(UsuarioModel player) {
		this.player1 = player;
	}
	public void setPlayer2(UsuarioModel player) {
		this.player2 = player;
	}
	public int getApuesta() {
		return this.apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	
	public RealModel(String nombre, UsuarioModel player1,int apuesta) {
		this.player1 = player1;
		this.player2=null;
		this.apuesta = apuesta;
		this.nombre = nombre;
	}
}
