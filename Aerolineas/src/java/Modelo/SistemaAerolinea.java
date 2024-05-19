package Modelo;

import java.util.*;

public class SistemaAerolinea {
    private HashMap<String, Vuelo> vuelos;
    private TreeMap<String, Ruta> rutas;

    public SistemaAerolinea() {
        vuelos = new HashMap<>();
        rutas = new TreeMap<>();
    }
    
    public void añadirVuelo(String numeroVuelo, int totalAsientos) {
        vuelos.put(numeroVuelo, new Vuelo(numeroVuelo, totalAsientos));
    }

    public Vuelo obtenerVuelo(String numeroVuelo) {
        return vuelos.get(numeroVuelo);
    }

    public void añadirRuta(String origen, String destino, int distancia) {
        Ruta ruta = new Ruta(origen, destino, distancia);
        rutas.put(origen + "-" + destino, ruta);
    }

    public Ruta obtenerRuta(String origen, String destino) {
        return rutas.get(origen + "-" + destino);
    }

    // Implementación de Dijkstra para encontrar la ruta más corta podría ir aquí
}
