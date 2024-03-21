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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import recursos.DuracionLicencia;
import recursos.TipoLicencia;

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table (name="licencias")
@DiscriminatorValue("licencias")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaExpedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    @Column(name = "fechaMax", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaMax;

    @Column(name = "tipoLicencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoLicencia tipoLicencia;

    @Column(name = "vigencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DuracionLicencia vigencia;

    public Licencia() {
    }

    public Licencia(Calendar fechaExpedicion, Calendar fechaMax, TipoLicencia tipoLicencia, DuracionLicencia vigencia, Calendar fechaEmision, float monto, Costo costo, Persona persona) {
        super(fechaEmision, monto, costo, persona);
        this.fechaExpedicion = fechaExpedicion;
        this.fechaMax = fechaMax;
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Calendar getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(Calendar fechaMax) {
        this.fechaMax = fechaMax;
    }

    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(TipoLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public DuracionLicencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(DuracionLicencia vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", fechaMax=" + fechaMax + ", tipoLicencia=" + tipoLicencia + ", vigencia=" + vigencia + '}';
    }

}
