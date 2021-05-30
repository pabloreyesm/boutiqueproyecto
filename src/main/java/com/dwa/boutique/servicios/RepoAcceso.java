package com.dwa.boutique.servicios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.dwa.boutique.modelo.Empleado;

public interface RepoAcceso extends CrudRepository<Empleado,Integer> {


	@Query(value = "SELECT * FROM empleado WHERE usuario = ?1 AND clave = ?2", nativeQuery = true)
	Empleado validar(String usuario, byte[] clave);
}
