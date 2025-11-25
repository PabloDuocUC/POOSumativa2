package model;

public class Ubicacion {
    private String comuna;
    private String region;

    //Se utiliza una validacion dentro del constructor
    public Ubicacion(String comuna, String region) {
        if (comuna == null || comuna.trim().isEmpty()) {
            throw new IllegalArgumentException("Comuna no puede ser vacio");
        }
        this.comuna = comuna;
        this.region = region != null ? region : "Región de Los Lagos"; // Region default utilizando condicionales terciarios
    }

    public String getComuna() {
        return comuna;
    }

    public String getRegion() {
        return region;
    }
    //No se agregan setter para mantener inmutabilidad

    @Override
    public String toString() {
        return "Ubicacion{" +
                "comuna='" + comuna + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
