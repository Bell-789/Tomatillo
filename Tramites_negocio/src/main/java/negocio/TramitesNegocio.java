/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAO.TramiteDAO;
import Entidades.Persona;
import Entidades.Tramite;
import dto.PersonaDTO;
import dto.TramiteDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class TramitesNegocio {

    private TramiteDAO tramiDAO;

    public TramitesNegocio() {
    }

    public TramitesNegocio(TramiteDAO tramiDAO) {
        this.tramiDAO = tramiDAO;
    }

    public List<TramiteDTO> consultarTramites() {
        try {
            List<Tramite> tramitesEncontrados = tramiDAO.consultarTramites();
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            for (Tramite tramitesEncontrado : tramitesEncontrados) {

                Calendar fechaEmisionCalendar = tramitesEncontrado.getFechaEmision();
                Date fechaEmisionDate = fechaEmisionCalendar.getTime(); // Convertir Calendar a Date

                TramiteDTO tramite = new TramiteDTO(
                        fechaEmisionDate,
                        tramitesEncontrado.getMonto(),
                        fromPersona(tramitesEncontrado.getPersona()));

                tramitesDTOEncontrados.add(tramite);
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesNegocio.class.getName()).log(Level.SEVERE, "No fue posible consultar la lista de tramites");
            return null;
        }
    }

    private PersonaDTO fromPersona(Persona persona) {
        return new PersonaDTO(
                persona.getNombre(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno()
        );
    }

}
