package uy.edu.cei.Obligatorio.Domain;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedQueries({
	@NamedQuery(name = "UsuarioModel.UserFindByUserName", query = "SELECT u FROM UsuarioModel u WHERE u.usuario = :usuario"),
	@NamedQuery(name = "UsuarioModel.buscarPorId", query = "SELECT u FROM UsuarioModel u WHERE u.id = :id"),
	@NamedQuery(name = "UsuarioModel.todos", query = "SELECT u FROM UsuarioModel u"),
	@NamedQuery(name = "UsuarioModel.victorias", query = "SELECT u FROM UsuarioModel u ORDER BY victorias DESC "),
	@NamedQuery(name = "UsuarioModel.puntos", query = "SELECT u FROM UsuarioModel u ORDER BY puntos DESC"),
	@NamedQuery(name = "UsuarioModel.reales", query = "SELECT u FROM UsuarioModel u ORDER BY reales DESC"),
	@NamedQuery(name = "UsuarioModel.virtuales", query = "SELECT u FROM UsuarioModel u ORDER BY virtuales DESC")
})
public class UsuarioModel implements Remote, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String usuario;
	private String contra;
	private int avatar;
	private int victorias;
	private int derrotas;
	private int puntos;
	private int reales;
	private int virtuales;
	/*
	@OneToMany(
			cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY
	)
	private List<RegistroModel> registros;
	*/
	public UsuarioModel() {
		
	}
	public UsuarioModel(String usuario, String contra,int avatar) {
		this.usuario = usuario;
		this.contra = contra;
		this.avatar = avatar;
		this.victorias=0;
		this.derrotas=0;
		this.puntos=0;
		this.reales=1000;
		this.virtuales=1000;
	}
	public UsuarioModel(String usuario, String contra,int avatar,int victorias,int puntos,int reales,int virtuales) {
		this.usuario = usuario;
		this.contra = contra;
		this.avatar = avatar;
		this.victorias=virtuales;
		this.derrotas=0;
		this.puntos=puntos;
		this.reales=reales;
		this.virtuales=victorias;
	}
	public Long getId() {
		return this.id;
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
	
	public int getVirtuales() {
		return this.virtuales;
	}
	public void setVirtuales(int virtuales) {
		this.virtuales = virtuales;
	}
	public int getReales() {
		return this.reales;
	}
	public void setReales(int reales) {
		this.reales = reales;
	}
	public int getVictorias() {
		return this.victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public int getDerrotas() {
		return this.derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getPuntos() {
		return this.puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getAvatar() {
		return this.avatar;
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
}
