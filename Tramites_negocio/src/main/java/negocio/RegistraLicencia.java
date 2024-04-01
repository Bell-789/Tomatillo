package negocio;

import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Forms.JLicenciaForm;
import excepciones.PersistenciaException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import recursos.DuracionLicencia;
import recursos.TipoLicencia;
import recursos.Validadores;

/**
 *
 * @author Chris, Bell y Katt
 */
public class RegistraLicencia {

    private Validadores validadores;
    private Persona per;
    private PersonaDAO perDAO;
    private LicenciaDAO licDAO;
    private JLicenciaForm form;
    private TipoLicencia tipo;
    private DuracionLicencia duracion;

    public RegistraLicencia() {
    }

    public RegistraLicencia(Validadores validadores, Persona per, PersonaDAO perDAO, LicenciaDAO licDAO, JLicenciaForm form) {
        this.validadores = validadores;
        this.per = per;
        this.perDAO = perDAO;
        this.licDAO = licDAO;
        this.form = form;
    }

    public void setValidadores(Validadores validadores) {
        this.validadores = validadores;
    }

    public void setPerDAO(PersonaDAO perDAO) {
        this.perDAO = perDAO;
    }

    public void setLicDAO(LicenciaDAO licDAO) {
        this.licDAO = licDAO;
    }

//    public void buscar(JLicenciaForm form, String RFC) {
//        if (RFC.isEmpty()) {
//            JOptionPane.showMessageDialog(form, "Por favor, ingrese el RFC para continuar", "Error: Campo vacío", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if (!validadores.validaRfc(RFC)) {
//            JOptionPane.showMessageDialog(form, "RFC inválido. Verifica que el RFC sea \n el correcto e ingréselo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        this.per = perDAO.consultarRFC(RFC);
//    }

//    public void realizarTramite(JLicenciaForm form) {
//        Licencia lic = new Licencia();
//        lic.setMonto(form.getMonto());
//        lic.setFechaEmision(Calendar.getInstance());
//        lic.setFechaExpedicion(Calendar.getInstance());
//        lic.setPersona(form.getPer());
//        lic.setTipoLicencia(form.getTipo());
//        lic.setVigencia(form.getDuracion());
//
//        if (lic.getPersona() == null) {
//            JOptionPane.showMessageDialog(form, "Persona no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        Licencia licN = null;
//        try {
//            licN = licDAO.insertarLicencia(lic);
//        } catch (PersistenciaException e) {
//            JOptionPane.showMessageDialog(form, "Trámite falló");
//        }
//
//        if (licN != null) {
//            JOptionPane.showMessageDialog(form, "Trámite realizado con éxito.\nCon folio: " + licN.getId());
//        }
//    }

}
