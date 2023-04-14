package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.MisPromociones;
import pe.idat.repository.MiPromoRepository;

@Service
public class MiPromocionServiceImpl implements MiPromocionService {

	@Autowired
	private MiPromoRepository repository;
	
	@Override
	public void guardar(MisPromociones misPromociones) {
		repository.save(misPromociones);

	}

	@Override
	public void actualizar(MisPromociones misPromociones) {
		repository.saveAndFlush(misPromociones);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<MisPromociones> listar() {
		
		return repository.findAll();
	}

	@Override
	public MisPromociones obtener(Integer id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<MisPromociones> listarByClienteId(Integer id) {
		
		return repository.listarByClienteId(id);
	}


}
