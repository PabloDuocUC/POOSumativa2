package services;
import model.CentroDeProduccion;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDeCentro {
    //se filtra por un minimo de toneladas indicadas por usuario
    public List<CentroDeProduccion> filtrarPorProduccion(List<CentroDeProduccion> centros, double minimoToneladas) {
        List<CentroDeProduccion> resultado = new ArrayList<>();
        for (CentroDeProduccion centro : centros) {
            if (centro.getToneladasProducidas() > minimoToneladas) {
                resultado.add(centro);
            }
        }
        return resultado;
    }

    //funcion para buscar centros por comuna
    public List<CentroDeProduccion> buscarPorComuna(List<CentroDeProduccion> centros, String comuna) {
        List<CentroDeProduccion> resultado = new ArrayList<>();
        for (CentroDeProduccion centro : centros) {
            if (centro.getComuna().equalsIgnoreCase(comuna)) {
                resultado.add(centro);
            }
        }
        return resultado;
    }

    //Funcion que calcula el total de la produccion
    public double calcularProduccionTotal(List<CentroDeProduccion> centros) {
        double total = 0;
        for (CentroDeProduccion centro : centros) {
            total += centro.getToneladasProducidas();
        }
        return total;
    }
}
