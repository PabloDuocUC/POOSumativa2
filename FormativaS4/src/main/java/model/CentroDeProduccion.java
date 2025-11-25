package model;

import javax.swing.plaf.ProgressBarUI;

public class CentroDeProduccion {
    //Se actualizo para añadir composicion
    private String nombre;
    private Ubicacion ubicacion;
    private Produccion produccion;
    //se crea constructor con sus respectivas validaciones
    public CentroDeProduccion(String nombre, Ubicacion ubicacion, Produccion produccion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío");
        }
        if (ubicacion == null) {
            throw new IllegalArgumentException("Ubicación no puede ser null");
        }
        if (produccion == null) {
            throw new IllegalArgumentException("Producción no puede ser null");
        }

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.produccion = produccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public String getComuna() {
        return ubicacion.getComuna();
    }

    public double getToneladasProducidas() {
        return produccion.getToneladas();
    }

    @Override
    public String toString() {
        return "CentroDeProduccion{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                ", produccion=" + produccion +
                '}';
    }
}
