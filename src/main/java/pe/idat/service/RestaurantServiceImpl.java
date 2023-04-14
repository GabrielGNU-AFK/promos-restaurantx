package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Restaurant;
import pe.idat.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;

	@Override
	public void guardar(Restaurant restaurant) {
		repository.save(restaurant);
	}

	@Override
	public void actualizar(Restaurant restaurant) {
		repository.saveAndFlush(restaurant);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<Restaurant> listar() {
		
		return repository.findAll();
	}
	
	@Override
	public Restaurant obtener(Integer id) {
	
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Restaurant> listarComidaRapida() {
		
		return repository.findAllComidaRapida();
	}

	@Override
	public List<Restaurant> listarComidaGourmet() {
		
		return repository.findAllGourmet();
	}

	@Override
	public List<Restaurant> listarComidaFamiliar() {
		return repository.findAllFamiliar();
	}

}
