package negocio;

import DAO.AutomovilDAO;
import DAO.PersonaDAO;
import Entidades.Automovil;
import Entidades.Persona;
import dto.AutomovilDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author Katt
 */
public class AutomovilesNegocio {

    private AutomovilDAO auto;
    private PersonaDAO persona;

    public AutomovilesNegocio() {
        this.auto = new AutomovilDAO();
    }

    public AutomovilesNegocio(AutomovilDAO auto) {
        this.auto = auto;
    }

    public AutomovilDTO registraraCarro(AutomovilDTO movil) throws PersistenciaException {
        Automovil automovil = new Automovil(movil.getNumSerie(), movil.getMarca(), movil.getColor(), movil.getModelo(), movil.getLinea(), movil.getTipo());

        Persona p = new Persona();
        p.setRfc(movil.getPersona().getRfc());

        p = persona.consultarRFC(p.getRfc());

        automovil.setPersona(p);

        auto.registrarAuto(automovil);

        return movil;

    }

}
