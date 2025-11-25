package model;

public class Produccion {
    private double toneladas;
    private String anio;
    private String tipoPescado;

    public Produccion(double toneladas, String anio, String tipoPescado) {
        if (toneladas < 0) {
            throw new IllegalArgumentException("Toneladas no puede ser negativo");
        }
        this.toneladas = toneladas;
        this.anio = anio != null ? anio : "2025";
        this.tipoPescado = tipoPescado != null ? tipoPescado : "Reineta";
    }

    public double getToneladas() {
        return toneladas;
    }

    public String getAnio() {
        return anio;
    }

    public String getTipoPescado() {
        return tipoPescado;
    }

    //Sin setters porque en el archivo se actualizan los registros(?) tengo la duda acá

    @Override
    public String toString() {
        return "Produccion{" +
                "toneladas=" + toneladas +
                ", anio='" + anio + '\'' +
                ", tipoPescado='" + tipoPescado + '\'' +
                '}';
    }
}
