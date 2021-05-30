// Generated with g9.

package com.dwa.boutique.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="detalleventa")
public class Detalleventa implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "iddetalleventa";

   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int iddetalleventa;
    @Column(nullable=false, precision=10)
    private int cantidad;
    @Column(nullable=false, precision=10)
    private BigDecimal preciounitario;
    @ManyToOne(optional=false)
    @JoinColumn(name="idproducto", nullable=false)
    private Producto producto;
    @ManyToOne(optional=false)
    @JoinColumn(name="idventa", nullable=false)
    private Venta venta;

    /** Default constructor. */
    public Detalleventa() {
        super();
    }

    /**
     * Access method for iddetalleventa.
     *
     * @return the current value of iddetalleventa
     */
    public int getIddetalleventa() {
        return iddetalleventa;
    }

    /**
     * Setter method for iddetalleventa.
     *
     * @param aIddetalleventa the new value for iddetalleventa
     */
    public void setIddetalleventa(int aIddetalleventa) {
        iddetalleventa = aIddetalleventa;
    }

    /**
     * Access method for cantidad.
     *
     * @return the current value of cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter method for cantidad.
     *
     * @param aCantidad the new value for cantidad
     */
    public void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    /**
     * Access method for preciounitario.
     *
     * @return the current value of preciounitario
     */
    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    /**
     * Setter method for preciounitario.
     *
     * @param aPreciounitario the new value for preciounitario
     */
    public void setPreciounitario(BigDecimal aPreciounitario) {
        preciounitario = aPreciounitario;
    }

    /**
     * Access method for producto.
     *
     * @return the current value of producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Setter method for producto.
     *
     * @param aProducto the new value for producto
     */
    public void setProducto(Producto aProducto) {
        producto = aProducto;
    }

    /**
     * Access method for venta.
     *
     * @return the current value of venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Setter method for venta.
     *
     * @param aVenta the new value for venta
     */
    public void setVenta(Venta aVenta) {
        venta = aVenta;
    }

    /**
     * Compares the key for this instance with another Detalleventa.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Detalleventa and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Detalleventa)) {
            return false;
        }
        Detalleventa that = (Detalleventa) other;
        if (this.getIddetalleventa() != that.getIddetalleventa()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Detalleventa.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Detalleventa)) return false;
        return this.equalKeys(other) && ((Detalleventa)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIddetalleventa();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Detalleventa |");
        sb.append(" iddetalleventa=").append(getIddetalleventa());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("iddetalleventa", Integer.valueOf(getIddetalleventa()));
        return ret;
    }

}
