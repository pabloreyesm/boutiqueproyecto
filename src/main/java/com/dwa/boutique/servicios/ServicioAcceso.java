package com.dwa.boutique.servicios;

import java.security.MessageDigest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dwa.boutique.modelo.Empleado;


@Service
public class ServicioAcceso {

	@Autowired
	private RepoAcceso repoAcceso;
	private String Mensaje;
	
	
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	public boolean validar(String usuario, String clave,HttpSession sesion)
	{
		Empleado emp = repoAcceso.validar(usuario,encriptar(clave));
	    if(emp != null) 
	    {
	    	sesion.setAttribute("iduser", emp.getIdempleado());
	    	Mensaje = emp.getNombre() + " - " + emp.getUsuario();
	    	return true;
	    	
	    }
	    Mensaje = "Usuario o Contraseña No Existe";
	    return false;
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
	
	public Empleado buscar(int id) {
		try {
			Empleado empleado = repoAcceso.findById(id).get();
			return empleado == null ? new Empleado() : empleado;
		}catch(Exception e) {
			this.Mensaje = "No se pudo realizar la busqueda del empleado.";
		    return null;
		}
}
}
