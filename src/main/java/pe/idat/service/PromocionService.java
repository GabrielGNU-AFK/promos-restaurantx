package pe.idat.service;

import java.util.List;

import pe.idat.model.Promocion;



public interface PromocionService {
	
	
	void guardar(Promocion promedio);
	void actualizar(Promocion promocion);
	void eliminar(Integer id);
	List<Promocion> listar();
	Promocion obtener(Integer id);
	List<Promocion> listarByRestaurantId(Integer id);

}
