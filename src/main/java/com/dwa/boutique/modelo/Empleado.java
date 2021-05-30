// Generated with g9.

package com.dwa.boutique.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="empleado")
public class Empleado implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idempleado";

  

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idempleado;
    @Column(nullable=false, length=40)
    private String nombre;
    @Column(nullable=false, length=50)
    private String apellidop;
    @Column(nullable=false, length=50)
    private String apellidom;
    @Column(nullable=false, length=10)
    private String telefono;
    @Column(nullable=false, length=60)
    private String direccion;
    @Column(nullable=false, length=20)
    private String usuario;
    @Column(nullable=false, length=20)
    private byte[] clave;
    @Column(name="Rol", nullable=false, length=15)
    private String rol;
    @OneToMany(mappedBy="empleado")
    private Set<Venta> venta;

    /** Default constructor. */
    public Empleado() {
        super();
    }

    /**
     * Access method for idempleado.
     *
     * @return the current value of idempleado
     */
    public int getIdempleado() {
        return idempleado;
    }

    /**
     * Setter method for idempleado.
     *
     * @param aIdempleado the new value for idempleado
     */
    public void setIdempleado(int aIdempleado) {
        idempleado = aIdempleado;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for apellidop.
     *
     * @return the current value of apellidop
     */
    public String getApellidop() {
        return apellidop;
    }

    /**
     * Setter method for apellidop.
     *
     * @param aApellidop the new value for apellidop
     */
    public void setApellidop(String aApellidop) {
        apellidop = aApellidop;
    }

    /**
     * Access method for apellidom.
     *
     * @return the current value of apellidom
     */
    public String getApellidom() {
        return apellidom;
    }

    /**
     * Setter method for apellidom.
     *
     * @param aApellidom the new value for apellidom
     */
    public void setApellidom(String aApellidom) {
        apellidom = aApellidom;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Access method for clave.
     *
     * @return the current value of clave
     */
    public byte[] getClave() {
        return clave;
    }

    /**
     * Setter method for clave.
     *
     * @param aClave the new value for clave
     */
    public void setClave(byte[] aClave) {
        clave = aClave;
    }

    /**
     * Access method for rol.
     *
     * @return the current value of rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Setter method for rol.
     *
     * @param aRol the new value for rol
     */
    public void setRol(String aRol) {
        rol = aRol;
    }

    /**
     * Access method for venta.
     *
     * @return the current value of venta
     */
    public Set<Venta> getVenta() {
        return venta;
    }

    /**
     * Setter method for venta.
     *
     * @param aVenta the new value for venta
     */
    public void setVenta(Set<Venta> aVenta) {
        venta = aVenta;
    }

    /**
     * Compares the key for this instance with another Empleado.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Empleado and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Empleado)) {
            return false;
        }
        Empleado that = (Empleado) other;
        if (this.getIdempleado() != that.getIdempleado()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Empleado.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Empleado)) return false;
        return this.equalKeys(other) && ((Empleado)other).equalKeys(this);
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
        i = getIdempleado();
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
        StringBuffer sb = new StringBuffer("[Empleado |");
        sb.append(" idempleado=").append(getIdempleado());
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
        ret.put("idempleado", Integer.valueOf(getIdempleado()));
        return ret;
    }

}
