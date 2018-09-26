package uy.edu.cei.Obligatorio.Server;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.Usuario;

public interface UsuarioService {
	public List<Usuario> ListaUsuarios();
	public String Hola();
}
