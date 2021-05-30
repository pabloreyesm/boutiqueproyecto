package com.dwa.boutique.controladores;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwa.boutique.modelo.Empleado;
import com.dwa.boutique.servicios.ServicioAcceso;
import com.dwa.boutique.servicios.ServicioEmpleado;


@Controller
public class AccesoController {

	@Autowired
	ServicioAcceso servicioAcceso;
	
	@Autowired
	ServicioEmpleado servicioEmpleado;
	
	@GetMapping(path = {"/acceso/acceder", "/"})
	public String validar() 
	{
		return "acceso/acceder";
	}
	
	@PostMapping("/acceso/acceder")
	public String agregar(@RequestParam("username") String usuario,@RequestParam("password") String clave, Model modelo)
	{
	
	   		return "redirect:/inicio/menu";
	}
	
	@GetMapping("/inicio/menu")
	public String menu(Model modelo,HttpSession sesion) 
	{
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		return "inicio/menu";
	}
	
	/*
	@PostMapping("/acceso/acceder")
	public String agregar(@RequestParam("usuario") String usuario,@RequestParam("clave") String clave, Model modelo,HttpSession sesion)
	{
	   	boolean accs = servicioAcceso.validar(usuario, clave,sesion);
	   	if(accs) 
	   	{
	   		return "redirect:/inicio/menu";
	   	}
	   	
	   	modelo.addAttribute("error", servicioAcceso.getMensaje());
	   	modelo.addAttribute("usuario",usuario);
	   	modelo.addAttribute("clave",clave);
	   	return "/acceso/acceder";
	}
	*/
	
	@GetMapping("/acceso/salir")
	public String salir(HttpSession sesion) {
		//SecurityContextHolder.clearContext();
		sesion.invalidate(); 
		return "redirect:/";
}
}