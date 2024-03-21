package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "costos")
public class Costo implements Serializable {

    @Id
    @Column(name = "idCosto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    @Column(name = "fechaPago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaPago;

    public Costo() {
    }

    public Costo(Long id, double cantidad, Calendar fechaPago) {
        this.id = id;
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
    }

    public Costo(double cantidad, Calendar fechaPago) {
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Costo{" + "id=" + id + ", cantidad=" + cantidad + ", fechaPago=" + fechaPago + '}';
    }

}
