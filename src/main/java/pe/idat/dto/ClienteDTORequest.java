package pe.idat.dto;



import lombok.Data;

@Data
public class ClienteDTORequest {
	
	private String nombres;
	private String apellidos;
	private Integer edad;
	private String nroCelular;
	private String direccion;
	private String dni;
	private String correo;
	private String usuario;
	private String password;

}
