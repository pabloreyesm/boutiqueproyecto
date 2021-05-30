package com.dwa.boutique.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dwa.boutique.modelo.Producto;

@Service
public class ServicioProducto {

	
	@Autowired
	private RepoProducto repoProducto;
	private String Mensaje;
	
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}	
	
	
	
	public boolean agregarProducto(Producto prod) 
	{
		try 
		{
			repoProducto.save(prod);
			this.Mensaje = "Se Agrego un Nuevo Producto Correctamente.";
			return true;
		}catch(Exception e)
		{
		  this.Mensaje = "Error al registrar el empleado.";
		  return false;
			
		}		
	}
	
	public boolean EliminarEmpleado(int id) 
	{
		try 
		{
			repoProducto.deleteById(id);
			this.Mensaje = "Se Elimino el Producto Correctamente.";
			return true;
		}catch(Exception e)
		{
		  this.Mensaje = "Error al Eliminar el Producto.";
		  return false;
			
		}		
	}
	
	public Iterable<Producto> ListarProductos()
	{
		try {
		    this.Mensaje="";
		    return repoProducto.findAll();
		}catch(Exception e) {
			this.Mensaje = e.getMessage();
			return null;
		}		
	}
		
	  public Optional<Producto> buscarProducto(int id)
	    {
	    	return repoProducto.findById(id);
	    }
	  
	  public Optional<Producto> buscarProductoventa(int codigo)
	    {
	    	return Optional.of(repoProducto.buscarproductoventa(codigo));
	    }
	  	  
	  
}
