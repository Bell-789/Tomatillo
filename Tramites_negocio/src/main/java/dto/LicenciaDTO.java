package dto;

import java.util.Calendar;
import recursos.DuracionLicencia;
import recursos.TipoLicencia;

/**
 *
 * @author Chris, bell y katt
 */
public class LicenciaDTO {

    private TipoLicencia tipo;
    private DuracionLicencia duracion;
    private Calendar fechaEmision;
    private Float monto;
    private PersonaDTO persona;

    public LicenciaDTO() {
    }

    public LicenciaDTO(TipoLicencia tipo, DuracionLicencia duracion, Calendar fechaEmision, Float monto, PersonaDTO persona) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.persona = persona;
    }

    public TipoLicencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoLicencia tipo) {
        this.tipo = tipo;
    }

    public DuracionLicencia getDuracion() {
        return duracion;
    }

    public void setDuracion(DuracionLicencia duracion) {
        this.duracion = duracion;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
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

}
