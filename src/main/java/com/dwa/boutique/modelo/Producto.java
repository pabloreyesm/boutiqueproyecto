// Generated with g9.

package com.dwa.boutique.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="producto")
public class Producto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idproducto";

  

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idproducto;
    @Column(nullable=false, precision=10)
    private int codigo;
    @Column(nullable=false, length=50)
    private String nombreproducto;
    @Column(nullable=false, length=100)
    private String descripcion;
    @Column(nullable=false, precision=10)
    private BigDecimal precio;
    @Column(nullable=false, precision=10)
    private int stock;
    @OneToMany(mappedBy="producto")
    private Set<Detalleventa> detalleventa;

    /** Default constructor. */
    public Producto() {
        super();
    }

    /**
     * Access method for idproducto.
     *
     * @return the current value of idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * Setter method for idproducto.
     *
     * @param aIdproducto the new value for idproducto
     */
    public void setIdproducto(int aIdproducto) {
        idproducto = aIdproducto;
    }

    /**
     * Access method for codigo.
     *
     * @return the current value of codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Setter method for codigo.
     *
     * @param aCodigo the new value for codigo
     */
    public void setCodigo(int aCodigo) {
        codigo = aCodigo;
    }

    /**
     * Access method for nombreproducto.
     *
     * @return the current value of nombreproducto
     */
    public String getNombreproducto() {
        return nombreproducto;
    }

    /**
     * Setter method for nombreproducto.
     *
     * @param aNombreproducto the new value for nombreproducto
     */
    public void setNombreproducto(String aNombreproducto) {
        nombreproducto = aNombreproducto;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for precio.
     *
     * @return the current value of precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Setter method for precio.
     *
     * @param aPrecio the new value for precio
     */
    public void setPrecio(BigDecimal aPrecio) {
        precio = aPrecio;
    }

    /**
     * Access method for stock.
     *
     * @return the current value of stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setter method for stock.
     *
     * @param aStock the new value for stock
     */
    public void setStock(int aStock) {
        stock = aStock;
    }

    /**
     * Access method for detalleventa.
     *
     * @return the current value of detalleventa
     */
    public Set<Detalleventa> getDetalleventa() {
        return detalleventa;
    }

    /**
     * Setter method for detalleventa.
     *
     * @param aDetalleventa the new value for detalleventa
     */
    public void setDetalleventa(Set<Detalleventa> aDetalleventa) {
        detalleventa = aDetalleventa;
    }

    /**
     * Compares the key for this instance with another Producto.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Producto and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Producto)) {
            return false;
        }
        Producto that = (Producto) other;
        if (this.getIdproducto() != that.getIdproducto()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Producto.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Producto)) return false;
        return this.equalKeys(other) && ((Producto)other).equalKeys(this);
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
        i = getIdproducto();
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
        StringBuffer sb = new StringBuffer("[Producto |");
        sb.append(" idproducto=").append(getIdproducto());
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
        ret.put("idproducto", Integer.valueOf(getIdproducto()));
        return ret;
    }

}
