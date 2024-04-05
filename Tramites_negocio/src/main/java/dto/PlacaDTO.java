package dto;

import java.util.Calendar;
import recursos.ValidaActivo;

/**
 *
 * @author Chris
 */
public class PlacaDTO {

    private AutomovilDTO vehiculo;
    private Calendar fechaRecepcion;
    private Calendar fechaEmision;
    private String numPlaca;
    private ValidaActivo estado;
    private Float monto;
    private PersonaDTO persona;
    private String tipoVehiculo;

    public PlacaDTO() {
    }

    public PlacaDTO(AutomovilDTO vehiculo, Calendar fechaRecepcion, Calendar fechaEmision, String numPlaca, ValidaActivo estado, Float monto, PersonaDTO persona, String tipoVehiculo) {
        this.vehiculo = vehiculo;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
        this.numPlaca = numPlaca;
        this.estado = estado;
        this.monto = monto;
        this.persona = persona;
        this.tipoVehiculo = tipoVehiculo;
    }

    public AutomovilDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(AutomovilDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public ValidaActivo getEstado() {
        return estado;
    }

    public void setEstado(ValidaActivo estado) {
        this.estado = estado;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
