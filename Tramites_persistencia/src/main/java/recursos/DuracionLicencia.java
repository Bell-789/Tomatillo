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

    private DuracionLicencia(int duracionMeses, float costoNormal, float costoDiscapacitado) {
        this.duracionMeses = duracionMeses;
        this.costoNormal = costoNormal;
        this.costoDiscapacitado = costoDiscapacitado;
    }

    public int getDuracionDias() {
        return duracionMeses;
    }

    public float getCostoNormal() {
        return costoNormal;
    }

    public float getCostoDiscapacitado() {
        return costoDiscapacitado;
    }

}
