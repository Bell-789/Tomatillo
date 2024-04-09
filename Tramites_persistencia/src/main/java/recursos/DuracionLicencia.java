package recursos;

/**
 *
 * @author Chris, bell y kathya
 */
public enum DuracionLicencia {
    UnAnio(12, 800, 500),
    dosAnios(24, 1400, 1100),
    tresAnios(36, 2000, 1600);

    private final int duracionMeses;
    private final float costoNormal;
    private final float costoDiscapacitado;

    /**
     * Cambia la duracion de la licencia dependiendo lo que pida
     * 
     * @param duracionMeses
     * @param costoNormal
     * @param costoDiscapacitado 
     */
    private DuracionLicencia(int duracionMeses, float costoNormal, float costoDiscapacitado) {
        this.duracionMeses = duracionMeses;
        this.costoNormal = costoNormal;
        this.costoDiscapacitado = costoDiscapacitado;
    }

    /**
     * Regresa la duracion en dias de la licencia
     * 
     * @return dias de duracion
     */
    public int getDuracionDias() {
        return duracionMeses;
    }

    /**
     * Regresa un costo normal 
     * 
     * @return costo normal
     */
    public float getCostoNormal() {
        return costoNormal;
    }

    /**
     * Regresa el costo de discapacitados
     * 
     * @return costo de discapacitados
     */
    public float getCostoDiscapacitado() {
        return costoDiscapacitado;
    }
}
