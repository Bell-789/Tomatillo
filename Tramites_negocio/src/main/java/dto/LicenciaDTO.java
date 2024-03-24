package dto;

import java.util.Calendar;
import recursos.DuracionLicencia;
import recursos.TipoLicencia;

/**
 *
 * @author Chris, bell y katt
 */
public class LicenciaDTO {

    private Calendar fechaExpedicion;
    private Calendar fechaMaxima;
    private TipoLicencia tipo;
    private DuracionLicencia duracion;

    public LicenciaDTO() {
    }

    public LicenciaDTO(Calendar fechaExpedicion, Calendar fechaMaxima, TipoLicencia tipo, DuracionLicencia duracion) {
        this.fechaExpedicion = fechaExpedicion;
        this.fechaMaxima = fechaMaxima;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public LicenciaDTO(Calendar fechaMaxima, TipoLicencia tipo, DuracionLicencia duracion) {
        this.fechaMaxima = fechaMaxima;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Calendar getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(Calendar fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
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

    @Override
    public String toString() {
        return "LicenciaDTO{" + "fechaExpedicion=" + fechaExpedicion + ", fechaMaxima=" + fechaMaxima + ", tipo=" + tipo + ", duracion=" + duracion + '}';
    }

}
