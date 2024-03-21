package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import recursos.TipoAutomovil;

/**
 *
 * @author Chris, bell y kat
 */
@Entity
@Table(name = "automoviles")
public class Automovil implements Serializable {

    @Id
    @Column(name = "idAutomovil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroSerie", nullable = false)
    private String numeroSerie;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "linea", nullable = false)
    private String linea;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAutomovil tipo;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @OneToMany(mappedBy = "automovil", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_placas")
    private List<Placa> placas;

    public Automovil() {
        this.placas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", marca=" + marca + ", color=" + color + ", modelo=" + modelo + ", linea=" + linea + ", tipo=" + tipo + ", persona=" + persona + ", placas=" + placas + '}';
    }

}
