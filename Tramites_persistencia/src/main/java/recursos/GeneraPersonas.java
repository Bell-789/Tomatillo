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
 * @author Chris, bell y kathya
 */
public class GeneraPersonas {

    /**
     * Constructor para generar las personas.
     */
    public GeneraPersonas() {
        RFC = generarRFC();
    }

    /**
     * Arreglo de los nombre completos de las personas.
     */
    private String[] nombres = {
        "Ana María", "Carlos Eduardo", "Sofía Isabel", "Juan Pablo", "Laura Fernanda",
        "Pedro José", "María José", "Andrés Felipe", "Valentina", "Luisa Fernanda",
        "Diego Alejandro", "Camila Andrea", "Javier Andrés", "Paula Alejandra", "Andrea Catalina",
        "José Daniel", "Daniela Patricia", "Mario Alberto", "Mónica Lorena", "Fernando José"
    };

    private String[] apellidoP = {
        "López", "Rodríguez", "Martínez", "Gómez", "Pérez", "García", "Hernández",
        "Díaz", "Ramírez", "Sánchez", "Castro", "Vargas", "Moreno", "Ramírez",
        "González", "Rojas", "Jiménez", "González", "Muñoz", "López"
    };

    /**
     * Arreglo de String con los apellidos maternos de las personas.
     */
    private String[] apellidoM = {
        "García", "Martínez", "González", "Rodríguez", "Hernández", "López", "Pérez",
        "Sánchez", "González", "Martínez", "Pérez", "López", "González", "Rodríguez",
        "Ramírez", "Martínez", "García", "López", "Sánchez", "Pérez"
    };

    /**
     * Arreglo para asignarle las fechas de nacimiento a las personas.
     */
    private Calendar[] fechaNacimiento = {Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
        Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance()};

    /**
     * Arreglo de String con el número de teléfono de cada persona.
     */
    private String[] telefono = {"8428930423", "9482734928", "3894857210", "0956892710", "9483230142",
        "0973824758", "9673412456", "9103940149", "9098923491", "9019341301",
        "9812351891", "1045192734", "9814352538", "1425821302", "1458295234",
        "8917845135", "9104819572", "5175175917", "9018575182", "5183715193"};

    /**
     * Arreglo de String con los RFC generados mediante el metodo.
     */
    private String[] RFC;

    /**
     * Método que genera el RFC de cada persona.
     *
     * @return Arreglo de String con los RFC generados para cada persona
     * insertada.
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
     * @return Lista con las personas insertadas.
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
