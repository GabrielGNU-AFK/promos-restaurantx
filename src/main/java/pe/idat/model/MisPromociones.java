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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="misPromociones")
public class MisPromociones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMipromo;
	private String mipromNombre;
	private String descrip;
	private String fechaFin;
	private Double miproPrecio;
	private String miproImage;
	
	@ManyToOne
	@JoinColumn(
			name="id_cliente",
			nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes(id_cliente)")
			
			)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cliente clientes;
	
	

}
