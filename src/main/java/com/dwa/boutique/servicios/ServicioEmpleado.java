package com.dwa.boutique.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Optional;

import com.dwa.boutique.modelo.Empleado;


@Service
public class ServicioEmpleado {

	@Autowired
	private RepoEmpleado repoEmpleado;
	private String Mensaje;
	
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}	
	
	public boolean agregarEmpleado(Empleado emp, String clave) 
	{
		try 
		{
			emp.setClave(encriptar(clave));
			//GUARDAR EN BD
			repoEmpleado.save(emp);
			this.Mensaje = "Se Agrego un Nuevo Empleado Correctamente.";
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
			repoEmpleado.deleteById(id);
			this.Mensaje = "Se Elimino el Empleado Correctamente.";
			return true;
		}catch(Exception e)
		{
		  this.Mensaje = "Error al Eliminar el Empleado.";
		  return false;
			
		}		
	}
	
	
	
	public Iterable<Empleado> ListarEmpleado()
	{
		try {
		    this.Mensaje="";
		    return repoEmpleado.findAll();
		}catch(Exception e) {
			this.Mensaje = e.getMessage();
			return null;
		}		
	}
	
	private byte[] encriptar(String clave) 
	{
		try 
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(clave.getBytes("utf8"));
			return digest.digest();
		}catch (Exception e) 
		{
			return null;
		}
		
	}
	
    public Optional<Empleado> buscarEmpleado(int id)
    {
    	return repoEmpleado.findById(id);
    }
}
