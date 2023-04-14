package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Promocion;
import pe.idat.repository.PromocionRepository;


@Service
public class PromocionServiceImpl implements PromocionService {
	
	
	@Autowired
	private PromocionRepository repository;
	
	@Override
	public void guardar(Promocion promedio) {
		repository.save(promedio);

	}

	@Override
	public void actualizar(Promocion promocion) {
		repository.saveAndFlush(promocion);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Promocion> listar() {
		return repository.findAll();
	}

	@Override
	public Promocion obtener(Integer id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Promocion> listarByRestaurantId(Integer id) {
		return repository.listarByRestauranteId(id);
	}

}
