package com.dwa.boutique.controladores;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwa.boutique.modelo.Empleado;
import com.dwa.boutique.modelo.Producto;
import com.dwa.boutique.modelo.Venta;
import com.dwa.boutique.modelo.Detalleventa;

import com.dwa.boutique.servicios.ServicioAcceso;
import com.dwa.boutique.servicios.ServicioProducto;
import com.dwa.boutique.servicios.ServicioVenta;

@Controller
public class VentaController {
	
	
	@Autowired
	ServicioAcceso servicioAcceso;
	
	@Autowired
	ServicioProducto servicioProducto;
	
	@Autowired
	ServicioVenta servicioVenta;
	

	@GetMapping("/venta/GestionVenta")
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
		return "venta/GestionVenta";
	}
	
	
	
	@PostMapping("/venta/buscarproducto")
	public String actualizar(@RequestParam("codigo") int codigo,@RequestParam("cantidad") int cantidad,
			@RequestParam("idventa") int idventa,@RequestParam("fecha") String fecha,Model modelo,HttpSession sesion) 
	{
		
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
	
		Iterable<Producto> productos = servicioProducto.ListarProductos();
		Optional<Producto>producto =servicioProducto.buscarProductoventa(codigo);
	
		modelo.addAttribute("producto",producto);
		modelo.addAttribute("productos",productos);
		
		modelo.addAttribute("cant", cantidad);
		modelo.addAttribute("idv", idventa);
		modelo.addAttribute("fech", fecha);
	
		LocalDate fec = LocalDate.parse(fecha.toString());
		
		Producto pro = servicioVenta.buscar(codigo);
        
		BigDecimal pre = pro.getPrecio().abs();
		int p = pre.intValue();	
	    int c  = cantidad * p;
		
		BigDecimal monto = BigDecimal.valueOf(c);
		modelo.addAttribute("mont", monto);
		
		Venta v = new Venta();
		
		v.setIdventa(idventa);
		v.setEmpleado(emp);
		v.setFecha(fec);
		v.setMonto(monto);
		
  
		if(servicioVenta.agregarVenta(v)) 
		{
			modelo.addAttribute("error",servicioVenta.getMensaje());
		}
        
		
		Venta ven = servicioVenta.buscarventa(v.getIdventa());
		Producto procd = servicioVenta.buscarproductodetalle(pro.getIdproducto());
		
		Detalleventa detalle = new Detalleventa();
		detalle.setVenta(ven);
		detalle.setProducto(procd);
		detalle.setCantidad(cantidad);
		detalle.setPreciounitario(pre);
		
		servicioVenta.agregarDetalle(detalle);

		return "venta/GestionVenta";
		
	}
	
	@GetMapping("/venta/VerVentas")
	public String verventa(Model modelo,HttpSession sesion) {
		
		int iduser = Integer.parseInt(sesion.getAttribute("iduser").toString());
		Empleado emp = servicioAcceso.buscar(iduser);
		modelo.addAttribute("emp",emp);
		
		
		Iterable<Venta> ven = servicioVenta.ListaV();
		modelo.addAttribute("product",ven);		
		return "venta/VerVentas";
	}
	
}
