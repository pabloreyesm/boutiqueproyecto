package com.dwa.boutique.servicios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.boutique.modelo.Producto;

public interface RepoProducto extends CrudRepository<Producto,Integer>  {

	
	@Query(value = "SELECT * FROM producto WHERE codigo = ?1", nativeQuery = true)
	Producto buscarproductoventa(int codigo);
	
	
}
