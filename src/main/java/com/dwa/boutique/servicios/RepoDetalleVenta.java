package com.dwa.boutique.servicios;

import org.springframework.data.repository.CrudRepository;

import com.dwa.boutique.modelo.Detalleventa;
public interface RepoDetalleVenta extends CrudRepository<Detalleventa,Integer> {

}
