package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta clase representa la tabla Automoviles en la base de datos.
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
     * Constructor por defecto que inicializa la lista de las placas.
     */
    public Automovil() {
        this.placas = new ArrayList<>();
    }

    public Automovil(String numeroSerie) {
        this.numeroSerie = numeroSerie;
        this.placas = new ArrayList<>();
    }

    /**
     * Constructor con atributos como parametros y inicializa una lista placas.
     *
     * @param modelo el modelo de el automovil.
     * @param linea la linea de el automovil.
     * @param tipo el tipo de carro (nuevo o usado).
     * @param persona la persona con el automovil.
     */
    public Automovil(String numeroSerie, String marca, String color, String modelo, String linea, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.placas = new ArrayList<>();
        this.persona = persona;
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
     *
     * @param numeroSerie el numero de serie a asignar.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Metodo para obtener la persona del automovil.
     *
     * @return regresa la persona del automovil.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo para asignar la persona al automovil.
     *
     * @param persona la persona a asignar.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo para obtener la marca del automovil.
     *
     * @return regresa la marca del automovil.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo para asignar la marca al automovil.
     *
     * @param marca la marca a asignar.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo para obtener el color del automovil.
     *
     * @return regresa el color del automovil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo para asignar el color al automovil.
     *
     * @param color el color a asignar.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo para obtner el modelo del automovil.
     *
     * @return regresa el modelo del automovil.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo para asignar el modelo al automovil.
     *
     * @param modelo el modelo a asignar.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo para obtner la linea del automovil.
     *
     * @return regresa la linea del automovil.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Metodo para asignar la linea al automovil.
     *
     * @param linea la linea a asignar.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Metodo para obtener la lista de las placas del automovil.
     *
     * @return regresa las placas del automovil.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Metodo para asignar la lista de las placas al automovil.
     *
     * @param placas la lista de placas a asignar.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Metodo para regresar los datos de los automoviles.
     *
     * @return String con los datos completos.
     */
    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", marca=" + marca + ", color=" + color + ", modelo=" + modelo + ", linea=" + linea + ", persona=" + persona + ", placas=" + placas + '}';
    }

}
