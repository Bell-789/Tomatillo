package dto;

import java.util.Calendar;

/**
 *
 * @author Bell
 *
 *si
 */
public class CostoDTO {

    private double cantidad;
    private Calendar fechaPago;

    public CostoDTO() {
    }

    public CostoDTO(double cantidad, Calendar fechaPago) {
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Calendar getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }

}
