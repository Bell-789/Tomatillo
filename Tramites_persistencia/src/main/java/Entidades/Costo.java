/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    @OneToOne
    @JoinColumn(name = "idTramite")
    private Tramite tramite;

    public Costo() {
    }

    public Costo(double cantidad, Calendar fechaPago, Tramite tramite) {
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
        this.tramite = tramite;
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

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @Override
    public String toString() {
        return "Costo{" + "id=" + id + ", cantidad=" + cantidad + ", fechaPago=" + fechaPago + ", tramite=" + tramite + '}';
    }

}
