package pe.idat.service;

import java.util.List;

import pe.idat.model.Restaurant;



public interface RestaurantService {
	
	void guardar(Restaurant restaurant);
	void actualizar(Restaurant restaurant);
	void eliminar(Integer id);
	List<Restaurant> listar();
	List<Restaurant> listarComidaRapida();
	List<Restaurant> listarComidaGourmet();
	List<Restaurant> listarComidaFamiliar();
	Restaurant obtener(Integer id);

}
