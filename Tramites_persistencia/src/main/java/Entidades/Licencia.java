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

/**
 *
 * @author Chris, bell y kathya
 */
@Entity
@Table(name = "licencias")
@DiscriminatorValue("licencias")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "tipoLicencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoLicencia tipoLicencia;

    @Column(name = "vigencia", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DuracionLicencia vigencia;

    public Licencia() {
    }

    public Licencia(TipoLicencia tipoLicencia, DuracionLicencia vigencia) {
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
    }

    public Licencia(TipoLicencia tipoLicencia, DuracionLicencia vigencia, Calendar fechaEmision, Float monto, Persona persona) {
        super(fechaEmision, monto, persona);
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
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

}
