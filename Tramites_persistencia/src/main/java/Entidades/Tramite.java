package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Tipo_tramite", discriminatorType = DiscriminatorType.STRING)
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

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_costo")
    private Costo costo;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public Tramite() {
    }

    public Tramite(Long id, Calendar fechaEmision, Float monto, Costo costo, Persona persona) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.costo = costo;
        this.persona = persona;
    }

    public Tramite(Calendar fechaEmision, Float monto, Costo costo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.costo = costo;
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

    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", monto=" + monto + ", costo=" + costo + ", persona=" + persona + '}';
    }

}
