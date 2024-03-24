package dto;

import Entidades.Costo;
import Entidades.Persona;
import java.util.Calendar;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDTO {
    
    private Calendar fechaEmision;
    private float monto;
    private Costo costo;
    private Persona persona;

    public TramiteDTO(Calendar fechaEmision, float monto, Costo costo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.costo = costo;
        this.persona = persona;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
    
}
