package negocio;

import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Forms.JLicenciaForm;
import dto.LicenciaDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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

//    public LicenciaDTO realizarTramite(LicenciaDTO licenciaDTO, String rfc) throws PersistenciaException {
//        try {
//            Licencia licencia = new Licencia(
//                    licenciaDTO.getFechaExpedicion(),
//                    licenciaDTO.getFechaMaxima(),
//                    licenciaDTO.getTipo(),
//                    licenciaDTO.getDuracion()
//            );
//
//            Persona persona = perDAO.consultarRFC(rfc);
//
//            if (persona == null) {
//                throw new PersistenciaException("No se encontró una persona con el RFC especificado.");
//            }
//
//            licencia.setFechaEmision(licenciaDTO.getFechaEmision());
//            licencia.setMonto(licenciaDTO.getMonto());
//            licencia.setPersona(persona);
//
//            licDAO.insertarLicencia(licencia);
//
//            return licenciaDTO;
//        } catch (PersistenciaException e) {
//
//            throw e;
//        } catch (Exception e) {
//
//            throw new PersistenciaException("Ocurrió un error al realizar el trámite: " + e.getMessage());
//        }
//    }

}
