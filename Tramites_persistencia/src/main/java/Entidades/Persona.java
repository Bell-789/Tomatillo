package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta clase representa la tabla Personas en la base de datos.
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    /**
     * Identificador de las personas.
     */
    @Id
    @Column(name = "idPersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * RFC de las personas.
     */
    @Column(name = "rfc", nullable = false, unique = true, length = 13)
    private String rfc;

    /**
     * Nombre de las personas.
     */
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombre;

    /**
     * Apellido paterno de las personas.
     */
    @Column(name = "apellido_paterno", nullable = false, length = 100)
    private String apellidoPaterno;

    /**
     * Apellido materno de las personas.
     */
    @Column(name = "apellido_materno", nullable = true, length = 100)
    private String apellidoMaterno;

    /**
     * Telefonos de las personas.
     */
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    /**
     * Fecha de nacimiento de las personas.
     */
    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    /**
     * Relacion uno a muchos entre personas y automoviles.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_automoviles")
    private List<Automovil> automoviles;

    /**
     * Relacion uno a muchos entre personas y tramites.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_tramites")
    private List<Tramite> tramites;

    /**
     * Constructor por defecto que inicializa lista de tramites y automoviles.
     */
    public Persona() {
        this.tramites = new ArrayList<>();
        this.automoviles = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param rfc el rfc de la persona.
     * @param nombre el nombre de la persona.
     * @param apellidoPaterno el apellido paterno de la persona.
     * @param apellidoMaterno el apellido materno de la persona.
     * @param telefono el telefono de la persona.
     * @param fechaNacimiento la fecha de nacimiento de la persona.
     */
    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tramites = new ArrayList<>();
        this.automoviles = new ArrayList<>();
    }

    /**
     * Metodo para obtener el id de la persona.
     *
     * @return regresa el id de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para asignar el id a la persona.
     *
     * @param id el id a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metdo para obtener el RFC de la persona.
     *
     * @return regresa el RFC de la persona
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Metodo para asignar el RFC a la persona.
     *
     * @param rfc el RFC a asignar.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Metodo para obtener el nombre de la persona.
     *
     * @return regresa el nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para asignar el nombre a la persona.
     *
     * @param nombre el nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el apellido paterno de la persona.
     *
     * @return regresa el apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo para asignar el apellido paterno a la persona.
     *
     * @param apellidoPaterno el apellido paterno a asignar.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo para obtener el apellido materno de la persona.
     *
     * @return regresa el apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo para asignar el apellido materno a la persona.
     *
     * @param apellidoMaterno el apellido materno a asignar.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo para obtener el telefono de la persona.
     *
     * @return regresa el telefono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo para asignar el telefono a la persona.
     *
     * @param telefono el telefono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para obtener la fecha de nacimiento de la persona.
     *
     * @return regresa la fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo para asignar la fecha de nacimiento a la persona.
     *
     * @param fechaNacimiento la fecha de nacimiento a asignar.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo para obtener la lista de los automoviles de la persona.
     *
     * @return regresa la lista de los automoviles de la persona.
     */
    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    /**
     * Metodo para asignar la lista de automoviles a la persona.
     *
     * @param automoviles la lista de automoviles a asignar.
     */
    public void setAutomoviles(List<Automovil> automoviles) {
        this.automoviles = automoviles;
    }

    /**
     * Metodo para obtener la lista de los tramite de la persona.
     *
     * @return regresa la lista de los tramites de la perosna.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Metodo para asignar la lista de tramites a la persona.
     *
     * @param tramites la lista de tramites a asignar.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

}
