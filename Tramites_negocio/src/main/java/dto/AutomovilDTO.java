package dto;

import recursos.TipoAutomovil;

/**
 *
 * @author Katt
 */
public class AutomovilDTO {

    private String numSerie;
    private String marca;
    private String color;
    private String modelo;
    private String linea;
    private TipoAutomovil tipo;
    private PersonaDTO persona;

    public AutomovilDTO() {
    }

    public AutomovilDTO(String numSerie, String marca, String color, String modelo, String linea, TipoAutomovil tipo, PersonaDTO persona) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.tipo = tipo;
        this.persona = persona;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

}
