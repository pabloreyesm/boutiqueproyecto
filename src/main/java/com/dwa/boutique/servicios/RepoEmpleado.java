package com.dwa.boutique.servicios;

import org.springframework.data.repository.CrudRepository;

import com.dwa.boutique.modelo.Empleado;

public interface RepoEmpleado extends CrudRepository<Empleado,Integer> {
  
}
