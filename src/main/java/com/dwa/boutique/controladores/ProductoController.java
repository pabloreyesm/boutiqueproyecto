package com.dwa.boutique.controladores;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dwa.boutique.modelo.Empleado;
import com.dwa.boutique.modelo.Producto;
import com.dwa.boutique.servicios.ServicioAcceso;
import com.dwa.boutique.servicios.ServicioProducto;

@Controller
public class ProductoController {

	@Autowired
	ServicioProducto servicioProducto;
	
	@Autowired
	ServicioAcceso servicioAcceso;
	
	
	
	@GetMapping("/producto/GestionProducto")
	public String listar(Model modelo,HttpSession sesion) {
		
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		
		
		Iterable<Producto> producto = servicioProducto.ListarProductos();
		if(producto!=null && producto.iterator().hasNext()) 
		{
			modelo.addAttribute("productos",producto);
		}
		else 
		{
			modelo.addAttribute("error","No Hay Productos Registrados.");
		}
		modelo.addAttribute("producto", new Producto());
		if(!servicioProducto.getMensaje().equals("")) 
		{
			modelo.addAttribute("error",servicioProducto.getMensaje());
		}
		return "producto/GestionProducto";
	}
	
	
	
	@PostMapping("/producto/agregar")
	public String agregar(Model modelo,@ModelAttribute Producto producto) 
	{
		boolean res = servicioProducto.agregarProducto(producto);
		if(res) 
		{
			return "redirect:/producto/GestionProducto";
		}
		modelo.addAttribute("error", servicioProducto.getMensaje());
		return "producto/GestionProducto";
	}
	
	
	
	@GetMapping("/producto/ActualizarProducto/{id}")
	public String actualizar(@PathVariable int id,Model modelo,HttpSession sesion) 
	{
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		
		Iterable<Producto> productos = servicioProducto.ListarProductos();
		Optional<Producto>producto =servicioProducto.buscarProducto(id);
		modelo.addAttribute("producto",producto);
		modelo.addAttribute("productos",productos);
	
		return "producto/GestionProducto";
	}
	
	@GetMapping("/producto/EliminarProducto/{id}")
	public String eliminar(@PathVariable int id,Model modelo) 
	{
		servicioProducto.EliminarEmpleado(id);
		return "redirect:/producto/GestionProducto";
	}
}
