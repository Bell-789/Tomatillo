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
 *
 * @author Chris, bell y kathya
 */
@Entity
@DiscriminatorValue("placa")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numPlaca", nullable = false, unique = true, length = 7)
    private String numPlaca;

    @Column(name = "fechaRecepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    @Column(name = "tipo_vehiculo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil automovil;

    public Placa() {
    }

    public Placa(String numPlaca, Calendar fechaRecepcion, TipoVehiculo tipoVehiculo, Automovil automovil) {
        this.numPlaca = numPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.tipoVehiculo = tipoVehiculo;
        this.automovil = automovil;
    }

    public Placa(String numPlaca, Calendar fechaRecepcion, TipoVehiculo tipoVehiculo, Automovil automovil, Calendar fechaEmision, Float monto, ValidaActivo activo, Persona persona) {
        super(fechaEmision, monto, activo, persona);
        this.numPlaca = numPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.tipoVehiculo = tipoVehiculo;
        this.automovil = automovil;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
