package recursos;

import Entidades.Persona;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author Chris
 */
public class GeneraPersonas {

    /**
     * Constructor de la clase VeintePersonas.
     */
    public GeneraPersonas() {
        fechaNacimiento = fechas();
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
    private Calendar[] fechaNacimiento;

    /**
     * Arreglo que agrega las fechas de nacimiento de los 20 insertados 
     * 
     * @return todas las fechas
     */
    public Calendar[] fechas() {
        Calendar[] c = new Calendar[20];

        Calendar f = Calendar.getInstance();
        f.set(2004, Calendar.JANUARY, 1);
        Calendar f2 = Calendar.getInstance();
        f2.set(1999, Calendar.FEBRUARY, 10);
        Calendar f3 = Calendar.getInstance();
        f3.set(2000, Calendar.MARCH, 1);
        Calendar f4 = Calendar.getInstance();
        f4.set(2009, Calendar.APRIL, 18);
        Calendar f5 = Calendar.getInstance();
        f5.set(1998, Calendar.MAY, 24);
        Calendar f6 = Calendar.getInstance();
        f6.set(1990, Calendar.JUNE, 28);
        Calendar f7 = Calendar.getInstance();
        f7.set(1979, Calendar.JULY, 5);
        Calendar f8 = Calendar.getInstance();
        f8.set(1990, Calendar.AUGUST, 3);
        Calendar f9 = Calendar.getInstance();
        f9.set(2002, Calendar.OCTOBER, 31);
        Calendar f10 = Calendar.getInstance();
        f10.set(2001, Calendar.SEPTEMBER, 14);
        Calendar f11 = Calendar.getInstance();
        f11.set(1977, Calendar.NOVEMBER, 2);
        Calendar f12 = Calendar.getInstance();
        f12.set(1996, Calendar.DECEMBER, 16);
        Calendar f13 = Calendar.getInstance();
        f13.set(2005, Calendar.JULY, 28);
        Calendar f14 = Calendar.getInstance();
        f14.set(1993, Calendar.APRIL, 24);
        Calendar f15 = Calendar.getInstance();
        f15.set(1988, Calendar.SEPTEMBER, 15);
        Calendar f16 = Calendar.getInstance();
        f16.set(1997, Calendar.DECEMBER, 15);
        Calendar f17 = Calendar.getInstance();
        f17.set(1970, Calendar.OCTOBER, 30);
        Calendar f18 = Calendar.getInstance();
        f18.set(1977, Calendar.JULY, 27);
        Calendar f19 = Calendar.getInstance();
        f19.set(1966, Calendar.FEBRUARY, 14);
        Calendar f20 = Calendar.getInstance();
        f20.set(2004, Calendar.JANUARY, 6);

        c[0] = f;
        c[1] = f2;
        c[2] = f3;
        c[3] = f4;
        c[4] = f5;
        c[5] = f6;
        c[6] = f7;
        c[7] = f8;
        c[8] = f9;
        c[9] = f10;
        c[10] = f11;
        c[11] = f12;
        c[12] = f13;
        c[13] = f14;
        c[14] = f15;
        c[15] = f16;
        c[16] = f17;
        c[17] = f18;
        c[18] = f19;
        c[19] = f20;

        return c;
    }

    /**
     * Arreglo de String con el número de teléfono de cada persona.
     */
    private String[] telefono = {"4859762837", "9482734928", "9098923491", "9483230142", "0956892710",
        "9673412456", "0973824758", "9103940149", "3894857210", "9019341301",
        "9812351891", "1045192734", "9814352538", "1425821302", "1458295234",
        "8917845135", "9104819572", "5175175917", "9018575182", "5183715193"};

    String llave = "key";

    /**
     * Metodo para generar una llave para la encriptacion
     *
     * @param llave que utilizamos
     * @return llave creada
     */
    public SecretKeySpec crearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec s = new SecretKeySpec(cadena, "AES");
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo para encriptar los telefonos de las personas
     *
     * @param encriptar para obtener los bytes
     * @return String encriptado
     */
    public String encriptar(String encriptar) {
        try {
            SecretKeySpec spec = crearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, spec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(encriptada);
            return cadena_encriptada;
        } catch (Exception ex) {
            ex.printStackTrace();
            return " ";
        }
    }

    /**
     * Metodo para desencriptar la clave generada anteriormente
     *
     * @param desencriptar Clave encriptada
     * @return La desencriptacion
     */
    public String desencriptar(String desencriptar) {
        try {
            SecretKeySpec spec = crearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, spec);

            byte[] cadena = Base64.getDecoder().decode(desencriptar);
            byte[] desencriptacion = cipher.doFinal(cadena);
            String cadena_desencriptacion = new String(desencriptacion);
            return cadena_desencriptacion;
        } catch (Exception ex) {
            ex.printStackTrace();
            return " ";
        }
    }

    /**
     * Metodo que encripta todos los telefonos de las personas
     *
     * @return Lista de telefonos encriptados
     */
    public String[] telefonosEncriptados() {
        String[] s = new String[20];

        for (int i = 0; i < s.length; i++) {
            String m = telefono[i];
            String arrow = encriptar(m);
            s[i] = arrow;
        }
        return s;
    }

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
            RFC.append(mes(fechaNacimiento[i].get(Calendar.MONTH) + 1));
            RFC.append(mes(fechaNacimiento[i].get(Calendar.DAY_OF_MONTH)));
            RFC.append(RandomStringUtils.randomAlphanumeric(3));
            RFCa[i] = RFC.toString().toUpperCase();
            RFC = null;
        }
        return RFCa;
    }

    /**
     * Metodo para sacar el mes del calendario 
     * 
     * @param i
     * @return mes en especifico con numeros
     */
    private String mes(int i) {
        if (i < 10) {
            return "0" + i;
        } else {
            return i + "";
        }
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
