package dto;

import java.util.Calendar;
import recursos.ValidaActivo;

/**
 *
 * @author Chris
 */
public class ManejaPlacaDTO {

    private AutomovilDTO vehiculo;
    private Calendar fechaRecepcion;
    private Calendar fechaEmision;
    private String numeroPlaca;
    private ValidaActivo estado;
    private Float monto;
    private PersonaDTO persona;
    private String tipoVehiculo;

    public ManejaPlacaDTO() {
    }

    public ManejaPlacaDTO(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
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

    public String getNumero() {
        return numeroPlaca;
    }

    public void setNumero(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
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
