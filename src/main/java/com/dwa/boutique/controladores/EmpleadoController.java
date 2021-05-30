package com.dwa.boutique.controladores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;


import com.dwa.boutique.servicios.ServicioEmpleado;
import com.dwa.boutique.servicios.ServicioAcceso;
import com.dwa.boutique.modelo.Empleado;
import javax.servlet.http.HttpSession;


@Controller
public class EmpleadoController {

	@Autowired
	ServicioEmpleado servicioEmpleado;

	@Autowired
	ServicioAcceso servicioAcceso;
	
	@GetMapping("/empleado/gestionempleado")
	public String listar(Model modelo ,HttpSession sesion) {
		
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		
		Iterable<Empleado> empleado = servicioEmpleado.ListarEmpleado();
		if(empleado!=null && empleado.iterator().hasNext()) 
		{
			modelo.addAttribute("empleados",empleado);
		}
		else 
		{
			modelo.addAttribute("error","No Hay Empleados Registrados.");
		}
		modelo.addAttribute("empleado", new Empleado());
		if(!servicioEmpleado.getMensaje().equals("")) 
		{
			modelo.addAttribute("error",servicioEmpleado.getMensaje());
		}
		return "empleado/gestionempleado";
	}
	
	@PostMapping("/empleado/agregar")
	public String agregar(Model modelo,@ModelAttribute Empleado empleado,
			@RequestParam("clave") String clave,HttpSession sesion) 
	{
		
		boolean res = servicioEmpleado.agregarEmpleado(empleado, clave);
		if(res) 
		{
			return "redirect:/empleado/gestionempleado";
		}
		modelo.addAttribute("error", servicioEmpleado.getMensaje());
		return "empleado/gestionempleado";
	}
	
	
	@GetMapping("/empleado/actualizarempleado/{id}")
	public String actualizar(@PathVariable int id,Model modelo,HttpSession sesion) 
	{
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		
		Iterable<Empleado> empleados = servicioEmpleado.ListarEmpleado();
		Optional<Empleado>empleado=servicioEmpleado.buscarEmpleado(id);
		modelo.addAttribute("empleado",empleado);
		modelo.addAttribute("empleados",empleados);
		

		return "empleado/gestionempleado";
	}
	
	@GetMapping("/empleado/eliminarempleado/{id}")
	public String eliminar(@PathVariable int id,Model modelo) 
	{
		servicioEmpleado.EliminarEmpleado(id);
		return "redirect:/empleado/gestionempleado";
	}
}
   