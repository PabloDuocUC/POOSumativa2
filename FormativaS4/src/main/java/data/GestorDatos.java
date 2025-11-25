package data;

import model.CentroDeProduccion;
import model.Produccion;
import model.Ubicacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    public List<CentroDeProduccion> leerCentros(String rutaArchivo) {
        List<CentroDeProduccion> listaCentros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++; //Contador de lineas

                // Si línea está vacia vuelvo al bucle
                if (linea.trim().isEmpty()) {
                    continue;
                }
                //Se utiliza system.err para una mayor profesionalidad
                try {
                    String[] datos = linea.split(";");

                    //Se valida el formato de los datos con un sout más bonito
                    if (datos.length != 3) {
                        System.err.println("Línea " + numeroLinea + " con formato incorrecto: " + linea);
                        continue;
                    }

                    String nombre = datos[0].trim();
                    String comuna = datos[1].trim();
                    double toneladas = Double.parseDouble(datos[2].trim());

                    // Validaciones personalizadas
                    if (nombre.isEmpty()) {
                        throw new IllegalArgumentException("Error! Nombre vacío");
                    }
                    if (comuna.isEmpty()) {
                        throw new IllegalArgumentException("Error! Comuna vacía");
                    }
                    if (toneladas < 0) {
                        throw new IllegalArgumentException("Error! Toneladas negativas");
                    }

                    //Utilizamos composicion en la creacion de objetos
                    //Se crean estos objetos default para hacer el codigo mas robusto y evitar errores.
                    Ubicacion ubicacion = new Ubicacion(comuna, null);
                    Produccion produccion = new Produccion(toneladas, null, null);
                    CentroDeProduccion centro = new CentroDeProduccion(nombre, ubicacion, produccion);

                    listaCentros.add(centro);

                } catch (NumberFormatException e) {
                    System.err.println("Línea " + numeroLinea + " - Error de formato numérico: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Línea " + numeroLinea + " - Datos inválidos: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Línea " + numeroLinea + " - Error inesperado: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        return listaCentros;
    }
}