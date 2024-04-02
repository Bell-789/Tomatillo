package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import recursos.TipoVehiculo;
import recursos.ValidaActivo;

/**
 * Esta clase representa la tabla Placas en la base de datos.
 *
 * @author Chris, bell y kathya
 */
@Entity
@DiscriminatorValue("placa")
public class Placa extends Tramite implements Serializable {

    /**
     * Numero de las placas.
     */
    @Column(name = "numPlaca", nullable = false, unique = true, length = 7)
    private String numPlaca;

    /**
     * Fecha de recepcion de las placas.
     */
    @Column(name = "fechaRecepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    /**
     * Tipo de vehiculo de las placas.
     */
    @Column(name = "tipo_vehiculo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    /**
     * Relacion muchos a uno entre placa y automovil.
     */
    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil automovil;

    /**
     * Constructor por defecto.
     */
    public Placa() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param numPlaca el numero de la placa.
     * @param fechaRecepcion la fecha de recepcion de la placa.
     * @param tipoVehiculo el tipo de vehiculo de la placa.
     * @param automovil el automovil de la placa.
     */
    public Placa(String numPlaca, Calendar fechaRecepcion, TipoVehiculo tipoVehiculo, Automovil automovil) {
        this.numPlaca = numPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.tipoVehiculo = tipoVehiculo;
        this.automovil = automovil;
    }

    /**
     * Constructor con atributos de la propia clase y todos los atributo de
     * clase super.
     *
     * @param numPlaca el numero de la placa.
     * @param fechaRecepcion la fecha de recepcion de la placa.
     * @param tipoVehiculo el tipo de vehiculo de la placa.
     * @param automovil el automovil de la placa.
     * @param fechaEmision la fecha de realizacion del tramite.
     * @param monto el precio a pagar por el tramite de la licencia.
     * @param activo el estado de la licencia.
     * @param persona la persona que realizo el tramite de la licencia.
     */
    public Placa(String numPlaca, Calendar fechaRecepcion, TipoVehiculo tipoVehiculo, Automovil automovil, Calendar fechaEmision, Float monto, ValidaActivo activo, Persona persona) {
        super(fechaEmision, monto, activo, persona);
        this.numPlaca = numPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.tipoVehiculo = tipoVehiculo;
        this.automovil = automovil;
    }

    /**
     * Metodo para obtener el numero de la placa.
     *
     * @return regresa el numero de la placa.
     */
    public String getNumPlaca() {
        return numPlaca;
    }

    /**
     * Metodo para asignar el numero de la placa.
     *
     * @param numPlaca el numero de placa a asignar.
     */
    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    /**
     * Metodo para obtener la fecha de recepcion de la placa.
     *
     * @return regresa la fecha de recepcion de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Metodo para asignar la fecha de recepcion de la placa.
     *
     * @param fechaRecepcion la fecha de recepcion a asignar.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Metodo para obtener el automovil de la placa.
     *
     * @return regresa el automovil de la placa.
     */
    public Automovil getAutomovil() {
        return automovil;
    }

    /**
     * Metodo para asignar el automovil a la placa.
     *
     * @param automovil el automovil a asignar.
     */
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    /**
     * Metodo para obtener el tipo de vehiculo de la placa.
     *
     * @return
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Metodo para asignar el tipo de vehiculo a la placa.
     *
     * @param tipoVehiculo el tipo de vehiculo a asignar.
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
