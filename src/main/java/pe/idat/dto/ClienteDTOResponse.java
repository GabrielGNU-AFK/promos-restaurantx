package pe.idat.dto;

public class ClienteDTOResponse {
	
	private Boolean respuesta;
	private String Mensaje;
	
	
	
	public ClienteDTOResponse(Boolean respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		Mensaje = mensaje;
	}
	public Boolean getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	

}
