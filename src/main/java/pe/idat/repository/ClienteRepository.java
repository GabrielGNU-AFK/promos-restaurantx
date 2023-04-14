package pe.idat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.idat.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Optional<Cliente> findByCorreo(String email);
	
	@Query(value="select p.* FROM clientes p inner join usuarios u on p.id_usuario=u.id_usuario where u.usuario LIKE ?1", nativeQuery = true)
	public Cliente findByUsuario(String usuario);

}
