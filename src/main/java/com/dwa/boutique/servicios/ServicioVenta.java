package com.dwa.boutique.servicios;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.boutique.modelo.Detalleventa;
import com.dwa.boutique.modelo.Producto;
import com.dwa.boutique.modelo.Venta;



@Service
public class ServicioVenta {
	
	@Autowired
	private RepoVenta repoVenta;
	
	@Autowired
	private RepoProducto repoProducto;
	
	@Autowired
	private RepoDetalleVenta repoDetalle;
	
	private String Mensaje;
	
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}	

	
	public boolean agregarVenta(Venta ven) 
	{
		try 
		{
			repoVenta.save(ven);
			this.Mensaje = "Venta Registrada";
			return true;
		}catch(Exception e)
		{
		  this.Mensaje = "Error al registrar la venta.";
		  return false;
			
		}		
	}
	
	public Producto buscar(int id) {
		try {
			Producto pro = repoProducto.buscarproductoventa(id);
			return pro == null ? new Producto() : pro;
		}catch(Exception e) {
		    return null;
		}
}
	
	
	public boolean agregarDetalle(Detalleventa detalle) 
	{
		try 
		{
			repoDetalle.save(detalle);
			return true;
		}catch(Exception e)
		{
		  this.Mensaje = "Error al registrar la venta.";
		  return false;
			
		}		
	}
	
	public Venta buscarventa(int id) {
		try {
			Venta venta = repoVenta.findById(id).get();
			return venta == null ? new Venta() : venta;
		}catch(Exception e) {
			this.Mensaje = "No se pudo realizar la busqueda.";
		    return null;
		}
	
    }
	
	public Producto buscarproductodetalle(int id) {
		try {
			Producto pro = repoProducto.findById(id).get();
			return pro == null ? new Producto() : pro;
		}catch(Exception e) {
			this.Mensaje = "No se pudo realizar la busqueda.";
		    return null;
		}
	
}
	
		public Iterable<Venta> ListaV()
		{
			try {
			    this.Mensaje="";
			    return repoVenta.todos();
			}catch(Exception e) {
				this.Mensaje = e.getMessage();
				return null;
			}		
		}
	
}