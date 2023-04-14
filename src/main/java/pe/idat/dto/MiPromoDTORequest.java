package pe.idat.dto;

import lombok.Data;
import pe.idat.model.Cliente;

@Data
public class MiPromoDTORequest {
	
	
	private String mipromNombre;
	private String descrip;
	private String fechaFin;
	private Double miproPrecio;
	private String miproImage;
	
	private Integer idCliente;
	
	

}
