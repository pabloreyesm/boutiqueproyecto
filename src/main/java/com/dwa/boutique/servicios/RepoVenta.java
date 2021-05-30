package com.dwa.boutique.servicios;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.dwa.boutique.modelo.Venta;


public interface RepoVenta extends CrudRepository<Venta,Integer> {

	@Query(value = "select *\r\n"
			+ "from venta \r\n"
			+ "inner join empleado on venta.idempleado = empleado.idempleado\r\n"
			+ "inner join detalleventa on venta.idventa = detalleventa.idventa\r\n"
			+ "inner join producto on producto.idproducto = detalleventa.idproducto", nativeQuery = true)
	ArrayList<Venta> todos();
}
