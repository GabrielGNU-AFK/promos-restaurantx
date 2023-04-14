package pe.idat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.idat.model.Cliente;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTOResponse {
	
	
	private Cliente cliente;
	private  Boolean rpta;

}
