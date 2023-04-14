package pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.idat.model.Promocion;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
	
	@Query(value="select p.* from promociones p inner join restaurantes r on p.id_restaurant=r.id_restaurant where p.id_restaurant = ?1", nativeQuery = true)
	public List<Promocion> listarByRestauranteId(Integer idRestaurant);

}
