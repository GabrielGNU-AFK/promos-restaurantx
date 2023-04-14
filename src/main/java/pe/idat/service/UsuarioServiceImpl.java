package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Usuario;
import pe.idat.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void guardar(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public void actualizar(Usuario usuario) {
		repository.saveAndFlush(usuario);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Usuario> listar() {
		
		return repository.findAll();
	}

	@Override
	public Usuario obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
