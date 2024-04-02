package negocio;

import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import Entidades.Licencia;
import Entidades.Persona;
import dto.LicenciaDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris
 */
public class LicenciasNegocio {

    private PersonaDAO pers;
    private LicenciaDAO licDAO;

    public LicenciasNegocio() {
        this.licDAO = new LicenciaDAO();
    }

    public LicenciasNegocio(LicenciaDAO licDAO) {
        this.licDAO = new LicenciaDAO();
    }

    public LicenciaDTO realizarTramite(LicenciaDTO licenciaDTO) throws PersistenciaException {

        Licencia licencia = new Licencia(
                licenciaDTO.getTipo(),
                licenciaDTO.getDuracion()
        );
        pers = new PersonaDAO();

        Persona persona = new Persona();
        persona.setRfc(licenciaDTO.getPersona().getRfc());

        persona = pers.consultarRFC(persona.getRfc());

        licencia.setFechaEmision(licenciaDTO.getFechaEmision());
        licencia.setMonto(licenciaDTO.getMonto());
        licencia.setPersona(persona);

        licDAO.insertarLicencia(licencia);

        return licenciaDTO;
    }
}
