/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import Entidades.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Chris
 */
public class GeneraPersonas {

    /**
     * Constructor de la clase VeintePersonas.
     */
    public GeneraPersonas() {
        RFC = generarRFC();

    }

    /**
     * Arreglo de String con los nombres de las personas.
     */
    private String[] nombres = {"Manuel Jose", "Manuel Juan", "Julio Luis", "Keyla", "Brian",
        "Pancho Antonio", "Rodolfo Roberto", "Luis Antonio", "Pablo", "Norma",
        "Harbor", "Samuel Luis", "Damian", "Ignacio Luis", "Luis Armando",
        "Karina", "Oscar Daniel", "Guillermo", "Martha", "Guadalupe"};

    /**
     * Arreglo de String con los apellidos paternos de las personas.
     */
    private String[] apellidoP = {"Carrizosa", "Bojorquez", "Lopez", "Jackson", "Molina",
        "Santos", "Araujo", "Sousa", "Silva", "Pereira",
        "Costa", "Ferreira", "Barbosa", "Pinto", "Castro",
        "Carvalho", "Oliveira", "Almeida", "Rocha", "Lima"};

    /**
     * Arreglo de String con los apellidos maternos de las personas.
     */
    private String[] apellidoM = {"Castro", "Borbon", "Quezada", "Ribeiro", "Pelo",
        "Carrizosa", "Goncalves", "Sousa", "Rocha", "Arellano",
        "Aponte", "Romero", "Verduzco", "Balencia", "Cavazos",
        "Mesa", "Varela", "Orozco", "Orozco", "Archuleta"};

    /**
     * Arreglo Calendar con la fecha de nacimiento de cada persona.
     */
    private Calendar[] fechaNacimiento = {Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance()};

    /**
     * Arreglo de String con el número de teléfono de cada persona.
     */
    private String[] telefono = {"4859762837", "9482734928", "9098923491", "9483230142", "0956892710",
        "9673412456", "0973824758", "9103940149", "3894857210", "9019341301",
        "9812351891", "1045192734", "9814352538", "1425821302", "1458295234",
        "8917845135", "9104819572", "5175175917", "9018575182", "5183715193"};

    /**
     * Arreglo de String con los RFC.
     */
    private String[] RFC;

    /**
     * Método que genera el RFC de cada persona.
     *
     * @return Arreglo de String con los RFC generados.
     */
    public String[] generarRFC() {
        String[] RFCa = new String[20];
        SimpleDateFormat anio = new SimpleDateFormat("yy");

        for (int i = 0; i < nombres.length; i++) {
            StringBuffer RFC = new StringBuffer();
            RFC.append(apellidoP[i].substring(0, 2));
            RFC.append(apellidoM[i].substring(0, 1));
            RFC.append(nombres[i].substring(0, 1));
            RFC.append(anio.format(fechaNacimiento[i].getTime()));
            RFC.append((fechaNacimiento[i].get(Calendar.MONTH) + 1));
            RFC.append((fechaNacimiento[i].get(Calendar.DAY_OF_MONTH)));
            RFC.append(RandomStringUtils.randomAlphanumeric(3));
            RFCa[i] = RFC.toString().toUpperCase();
            RFC = null;
        }
        return RFCa;
    }

    /**
     * Método para obtener las personas.
     *
     * @return Lista con las personas.
     */
    public List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < RFC.length; i++) {
            Persona per = new Persona();
            per.setNombre(nombres[i]);
            per.setApellidoPaterno(apellidoP[i]);
            per.setApellidoMaterno(apellidoM[i]);
            per.setFechaNacimiento(fechaNacimiento[i]);
            per.setRfc(RFC[i]);
            per.setTelefono(telefono[i]);
            personas.add(per);
        }
        return personas;
    }
}
