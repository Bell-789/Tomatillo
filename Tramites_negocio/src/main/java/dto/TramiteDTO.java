package dto;

import java.util.Calendar;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDTO {

    private Calendar fechaEmision;
    private Integer monto;

    public TramiteDTO() {
    }

    public TramiteDTO(Calendar fechaEmision, Integer monto) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TramiteDTO{" + "fechaEmision=" + fechaEmision + ", monto=" + monto + '}';
    }

}
