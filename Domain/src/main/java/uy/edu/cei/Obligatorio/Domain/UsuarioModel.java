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
	@NamedQuery(name = "UsuarioModel.buscarPorId", query = "SELECT u FROM UsuarioModel u WHERE u.id = :id")
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
}
