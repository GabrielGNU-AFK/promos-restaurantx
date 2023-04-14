package pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.idat.model.MisPromociones;

@Repository
public interface MiPromoRepository extends JpaRepository<MisPromociones, Integer> {
	
	@Query(value="select m.* from mis_promociones m inner join clientes c on m.id_cliente=c.id_cliente where m.id_cliente= ?1", nativeQuery = true)
	public List<MisPromociones> listarByClienteId(Integer idCliente);

}
