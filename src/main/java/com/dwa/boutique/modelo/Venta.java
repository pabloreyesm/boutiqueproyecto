// Generated with g9.

package com.dwa.boutique.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="venta")
public class Venta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** Primary key. */
    protected static final String PK = "idventa";


    @Id
    @Column(unique=true, nullable=false, precision=10)
    private int idventa;
    @Column(nullable=false)
    private LocalDate fecha;
    @Column(nullable=false, precision=10)
    private BigDecimal monto;
    @ManyToOne(optional=false)
    @JoinColumn(name="idempleado", nullable=false)
    private Empleado empleado;
    @OneToMany(mappedBy="venta")
    private Set<Detalleventa> detalleventa;

    /** Default constructor. */
    public Venta() {
        super();
    }

    /**
     * Access method for idventa.
     *
     * @return the current value of idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * Setter method for idventa.
     *
     * @param aIdventa the new value for idventa
     */
    public void setIdventa(int aIdventa) {
        idventa = aIdventa;
    }

    /**
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(LocalDate aFecha) {
        fecha = aFecha;
    }

    /**
     * Access method for monto.
     *
     * @return the current value of monto
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Setter method for monto.
     *
     * @param aMonto the new value for monto
     */
    public void setMonto(BigDecimal aMonto) {
        monto = aMonto;
    }

    /**
     * Access method for empleado.
     *
     * @return the current value of empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Setter method for empleado.
     *
     * @param aEmpleado the new value for empleado
     */
    public void setEmpleado(Empleado aEmpleado) {
        empleado = aEmpleado;
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
     * Compares the key for this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Venta and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Venta)) {
            return false;
        }
        Venta that = (Venta) other;
        if (this.getIdventa() != that.getIdventa()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Venta)) return false;
        return this.equalKeys(other) && ((Venta)other).equalKeys(this);
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
        i = getIdventa();
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
        StringBuffer sb = new StringBuffer("[Venta |");
        sb.append(" idventa=").append(getIdventa());
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
        ret.put("idventa", Integer.valueOf(getIdventa()));
        return ret;
    }

}
