package ui;

import data.GestorDatos;
import model.CentroDeProduccion;
import services.ServiciosDeCentro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();
        ServiciosDeCentro servicio = new ServiciosDeCentro();

        String rutaArchivo = "src/main/resources/centrosDeProduccion.txt";
        //Se cargan los centros
        List<CentroDeProduccion> listaCentros = gestor.leerCentros(rutaArchivo);

        //Se valida una correcta carga de los centros
        if (listaCentros.isEmpty()) {
            System.out.println("No se pudieron cargar centros. Verifica el archivo.");
            return;
        }

        //Recorrido del archivo almacenado en una lista
        System.out.println("Lista de todos los centros de produccion: (objetos)");
        for (CentroDeProduccion centro : listaCentros) {
            System.out.println(centro); //Imprimimos datos de los objetos gracias a ToString
        }

        //Filtro de centros con más de 1000kg de produccion
        System.out.println("Lista de centros de produccion con más de 1000 toneladas en produccion: ");

        List<CentroDeProduccion> filtrados = servicio.filtrarPorProduccion(listaCentros, 1000);
        for (CentroDeProduccion centro : filtrados) {
            System.out.println(centro.getNombre() + ": " + centro.getToneladasProducidas() + " toneladas");
        }


        //busqueda para filtrar por nombre de comuna
        System.out.println("Buscar centro de produccion: ");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Buscar por comuna\nIngrese comuna: ");
        String comunaBuscada = scanner.nextLine();

        List<CentroDeProduccion> encontrados = servicio.buscarPorComuna(listaCentros, comunaBuscada);
        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron centros en: " + comunaBuscada);
        } else {
            System.out.println("Lista de centros encontrados en " + comunaBuscada + ":");
            for (CentroDeProduccion centro : encontrados) {
                System.out.println("  - " + centro.getNombre());
            }
        }

        scanner.close();
    }
}