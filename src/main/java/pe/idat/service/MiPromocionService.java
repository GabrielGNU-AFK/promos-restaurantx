package pe.idat.service;

import java.util.List;

import pe.idat.model.MisPromociones;



public interface MiPromocionService {
	
	void guardar(MisPromociones misPromociones);
	void actualizar(MisPromociones misPromociones);
	void eliminar(Integer id);
	List<MisPromociones> listar();
	MisPromociones obtener(Integer id);
	
	List<MisPromociones> listarByClienteId(Integer id);

}
