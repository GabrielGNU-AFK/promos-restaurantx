package pe.idat.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.idat.dto.PromoDTORequest;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="promociones")
public class Promocion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromocion;
	private String nombrePromo;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private Double precioPromo;
	private String imagenPromo;
	
	@ManyToOne
	@JoinColumn(
			name="id_restaurant",
			nullable=false
			)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Restaurant restaurantes;
	
	public Promocion(PromoDTORequest request) {
		this.nombrePromo=request.getNombrePromo();
		this.descripcion=request.getDescripcion();
		this.fechaInicio=request.getFechaInicio();
		this.fechaFin=request.getFechaFin();
		this.imagenPromo=request.getImagenPromo();
		this.precioPromo=request.getPrecioPromo();
		
	}

}
