package pe.idat.service;

import java.util.List;

import pe.idat.model.Usuario;


public interface UsuarioService {
	
	void guardar(Usuario usuario);
	void actualizar(Usuario usuario);
	void eliminar(Integer id);
	List<Usuario> listar();
	Usuario obtener(Integer id);

}
