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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "tramites")
public class Tramite implements Serializable {

    @Id
    @Column (name="idTramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaEmision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;

    @Column(name = "monto", nullable = false)
    private float monto;

    @OneToOne(mappedBy = "tramite")
    private Costo costo;

    public Tramite() {
    }

    public Tramite(Calendar fechaEmision, float monto, Costo costo) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
