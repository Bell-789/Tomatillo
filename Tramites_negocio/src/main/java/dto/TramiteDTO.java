package dto;

import java.util.Date;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDTO {

    private Date fechaEmision;
    private float monto;
    private PersonaDTO personaDTO;

    public TramiteDTO() {

    }

    public TramiteDTO(Date fechaEmision, float monto, PersonaDTO personaDTO) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.personaDTO = personaDTO;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    @Override
    public String toString() {
        return "TramiteDTO{" + "fechaEmision=" + fechaEmision + ", monto=" + monto + '}';
    }

}
