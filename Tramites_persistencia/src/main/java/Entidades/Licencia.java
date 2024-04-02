package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import recursos.DuracionLicencia;
import recursos.TipoLicencia;
import recursos.ValidaActivo;

/**
 * Esta clase representa la tabla Licencias en la base de datos.
 *
 * @author Chris, bell y kat
 */
@Entity
@Table(name = "licencias")
@DiscriminatorValue("licencias")
public class Licencia extends Tramite implements Serializable {

    /**
     * Tipo de las licencias.
     */
    @Column(name = "tipoLicencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoLicencia tipoLicencia;

    /**
     * Duracion de las licencias.
     */
    @Column(name = "vigencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DuracionLicencia vigencia;

    /**
     * Constructor por defecto.
     */
    public Licencia() {
    }

    /**
     * Constructor con atributos de la propia clase en sus parametros.
     *
     * @param tipoLicencia el tipo de licencia normal / discapacitado.
     * @param vigencia la vigencia de la licencia.
     */
    public Licencia(TipoLicencia tipoLicencia, DuracionLicencia vigencia) {
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
    }

    /**
     * Constructor con atributos de la propia clase y 1 atributo de clase super.
     *
     * @param tipoLicencia el tipo de licencia normal / discapacitado.
     * @param vigencia la vigencia de la licencia.
     * @param activo el estado de la licencia.
     */
    public Licencia(TipoLicencia tipoLicencia, DuracionLicencia vigencia, ValidaActivo activo) {
        super(activo);
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
    }

    /**
     * Constructor con atributos de la propia clase y todos los atributo de
     * clase super.
     *
     * @param tipoLicencia el tipo de licencia normal / discapacitado.
     * @param vigencia la vigencia de la licencia.
     * @param fechaEmision la fecha de realizacion del tramite.
     * @param monto el precio a pagar por el tramite de la licencia.
     * @param activo el estado de la licencia.
     * @param persona la persona que realizo el tramite de la licencia.
     */
    public Licencia(TipoLicencia tipoLicencia, DuracionLicencia vigencia, Calendar fechaEmision, Float monto, ValidaActivo activo, Persona persona) {
        super(fechaEmision, monto, activo, persona);
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
    }

    /**
     * Metodo para obtener el tipo de licencia.
     *
     * @return regresa el tipo de licencia (normal / discapacitado).
     */
    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }

    /**
     * Metodo para asignar el tipo de licencia.
     *
     * @param tipoLicencia el tipo a asignar (normal / discapacitado).
     */
    public void setTipoLicencia(TipoLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * Metodo para obtener la vigencia de la licencia.
     *
     * @return regresa la vigencia de la licencia.
     */
    public DuracionLicencia getVigencia() {
        return vigencia;
    }

    /**
     * Metodo para asignar la vigencia de la licencia.
     *
     * @param vigencia la vigencia a asignar.
     */
    public void setVigencia(DuracionLicencia vigencia) {
        this.vigencia = vigencia;
    }

}
