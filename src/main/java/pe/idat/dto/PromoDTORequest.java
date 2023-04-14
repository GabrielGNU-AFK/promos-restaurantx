package pe.idat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoDTORequest {
	
	private String nombrePromo;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private Double precioPromo;
	private String imagenPromo;
	
	private int idRestaurant;

}
