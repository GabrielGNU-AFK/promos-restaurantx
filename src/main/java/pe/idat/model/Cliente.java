package pe.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.idat.dto.ClienteDTORequest;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="clientes")
public class Cliente  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombres;
	private String apellidos;
	private Integer edad;
	private String nroCelular;
	private String direccion;
	private String dni;
	@Column(unique = true)
	private String correo;
	
	@JoinColumn(name="id_usuario")
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "clientes")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<MisPromociones> mispromociones=new ArrayList<>();
	
	public Cliente(ClienteDTORequest request) {
		this.nombres=request.getNombres();
		this.apellidos=request.getApellidos();
		this.edad=request.getEdad();
		this.nroCelular=request.getNroCelular();
		this.direccion=request.getDireccion();
		this.dni=request.getDni();
		this.correo=request.getCorreo();
	
	}

	



	
	
}
