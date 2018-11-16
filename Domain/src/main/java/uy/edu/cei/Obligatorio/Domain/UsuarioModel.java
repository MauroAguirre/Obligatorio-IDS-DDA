package uy.edu.cei.Obligatorio.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedQuery(name = "UsuarioModel.UserFindByUserName", query = "SELECT u FROM UsuarioModel u WHERE u.usuario = :usuario")
public class UsuarioModel implements Serializable {
	
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
	@OneToMany(
			cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY
	)
	private List<RegistroModel> registros;
	
	public UsuarioModel() {
		
	}
	public UsuarioModel(String usuario, String contra) {
		this.usuario = usuario;
		this.contra = contra;
		this.registros = new ArrayList<>();
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
	public List<RegistroModel> getRegistros(){
		return this.registros;
	}
}
