package uy.edu.cei.Obligatorio.Server;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioService {
	public List<UsuarioModel> ListaUsuarios();
	public String Hola();
}
