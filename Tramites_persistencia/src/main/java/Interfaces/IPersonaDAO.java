/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Persona;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris, bell y kat
 */
public interface IPersonaDAO {

    public Persona insertar(Persona per) throws PersistenciaException;

    public void insertar20Personas(List<Persona> personas) throws PersistenciaException;

}
