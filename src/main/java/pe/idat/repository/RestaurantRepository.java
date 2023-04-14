package pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.idat.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{ 
	
	@Query("Select r from Restaurant r where r.categoriaRestaurant='Comida Rapida' ")
	List<Restaurant> findAllComidaRapida();
	
	@Query("Select r from Restaurant r where r.categoriaRestaurant='Gourmet' ")
	List<Restaurant> findAllGourmet();
	
	@Query("Select r from Restaurant r where r.categoriaRestaurant='Familiar' ")
	List<Restaurant> findAllFamiliar();
	
	

}
