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

    /**
     * Identificador de los automoviles.
     */
    @Id
    @Column(name = "idAutomovil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numero de serie de los automoviles.
     */
    @Column(name = "numeroSerie", nullable = false)
    private String numeroSerie;

    /**
     * Marca de los automoviles.
     */
    @Column(name = "marca", nullable = false)
    private String marca;

    /**
     * Color de los automoviles.
     */
    @Column(name = "color", nullable = false)
    private String color;

    /**
     * Modelo de los automoviles.
     */
    @Column(name = "modelo", nullable = false)
    private String modelo;

    /**
     * Linea de los automoviles.
     */
    @Column(name = "linea", nullable = false)
    private String linea;

    /**
     * Tipo de los automoviles (nuevo o usado).
     */
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAutomovil tipo;

    /**
     * Relacion muchos a uno con la persona.
     */
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    /**
     * Relacion uno a muchos con las placas.
     */
    @OneToMany(mappedBy = "automovil", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_placas")
    private List<Placa> placas;

    /**
     * Constructor por defercto que inicializa la lista de las placas.
     */
    public Automovil() {
        this.placas = new ArrayList<>();
    }

    /**
     * Constructor con atributos como parametros y inicializa una lista placas.
     *
     * @param numeroSerie el numero de serie de el automovil.
     * @param marca la marca de el automovil.
     * @param color el color de el automovil.
     * @param modelo el modelo de el automovil.
     * @param linea la linea de el automovil.
     * @param tipo el tipo de carro (nuevo o usado).
     * @param persona la persona con el automovil.
     */
    public Automovil(String numeroSerie, String marca, String color, String modelo, String linea, TipoAutomovil tipo, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.tipo = tipo;
        this.persona = persona;
        this.placas = new ArrayList<>();
    }

    /**
     * Metodo para obtener el id del automovil.
     *
     * @return regresa el id del automovil.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para asignar el id al automovil.
     *
     * @param id el id a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el numero de serie del automovil.
     *
     * @return regresa el numero de serie del automovil.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Metodo para asignar el numero de serie al automovil.
     * @param numeroSerie 
     */
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
