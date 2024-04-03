package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import recursos.ValidaActivo;

/**
 * Esta clase representa la tabla Tramites en la base de datos.
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    /**
     * Identificador de los tramites.
     */
    @Id
    @Column(name = "idTramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha de emision de los tramites.
     */
    @Column(name = "fechaEmision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;

    /**
     * Monto de los tramites.
     */
    @Column(name = "monto", nullable = false)
    private Float monto;

    /**
     * Estado de los tramites.
     */
    @Column(name = "Estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ValidaActivo activo;

    /**
     * Relacion muchos a uno entre tramite y persona.
     */
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    /**
     * Tipo de los tramites.
     */
    private String tipo_tramite;

    /**
     * Constructor por defecto.
     */
    public Tramite() {
    }

    /**
     * Constructor con 1 atributo de la clase en su parametro.
     *
     * @param activo el estado de el tramite.
     */
    public Tramite(ValidaActivo activo) {
        this.activo = activo;
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param fechaEmision la fecha de realizacion del tramite.
     * @param monto el precio a pagar por el tramite de la licencia.
     * @param activo el estado de la licencia.
     * @param persona la persona que realizo el tramite de la licencia.
     */
    public Tramite(Calendar fechaEmision, Float monto, ValidaActivo activo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.activo = activo;
        this.persona = persona;
    }

    /**
     * Metodo para obtener el id del tramite.
     *
     * @return regresa el id del tramite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para asignar el id al tramite.
     *
     * @param id el id a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener la fecha de emision del tramite.
     *
     * @return regresa la fecha de emision del tramite.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Metodo para asignar la fecha de emision del tramite.
     *
     * @param fechaEmision la fecha de emision a asignar.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Metodo para obtener el monto del tramite.
     *
     * @return regresa el monto del tramite.
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Metodo para asignar el monto del tramite.
     *
     * @param monto el monto a asignar.
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * Metodo para obtener la persona del tramite.
     *
     * @return regresa la persona del tramite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo para asignar una persona al tramite.
     *
     * @param persona la persona a asignar.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo para obtener el tipo del tramite.
     *
     * @return regresa el tipo del tramite.
     */
    public String getTipo_tramite() {
        return tipo_tramite;
    }

    /**
     * Metodo para asignar el tipo del tramite.
     *
     * @param tipo_tramite el tipo de tramite a asignar.
     */
    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }

    public ValidaActivo getActivo() {
        return activo;
    }

    public void setActivo(ValidaActivo activo) {
        this.activo = activo;
    }

}
