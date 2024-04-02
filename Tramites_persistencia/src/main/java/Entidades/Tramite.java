package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import recursos.ValidaActivo;

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @Column(name = "idTramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaEmision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;

    @Column(name = "monto", nullable = false)
    private Float monto;

    @Column(name = "Estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ValidaActivo activo;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    private String tipo_tramite;

    public Tramite() {
    }

    public Tramite(Calendar fechaEmision, Float monto, ValidaActivo activo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.activo = activo;
        this.persona = persona;
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

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipo_tramite() {
        return tipo_tramite;
    }

    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }

}
