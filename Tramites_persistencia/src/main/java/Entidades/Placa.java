/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table (name="placas")
@DiscriminatorValue("placas")
public class Placa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numPlaca", nullable = false, unique = true, length = 7)
    private String numPlaca;

    @Column(name = "fechaRecepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil automovil;

    public Placa() {
    }

    public Placa(String numPlaca, Calendar fechaRecepcion, Automovil automovil) {
        this.numPlaca = numPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.automovil = automovil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", numPlaca=" + numPlaca + ", fechaRecepcion=" + fechaRecepcion + ", automovil=" + automovil + '}';
    }

}
