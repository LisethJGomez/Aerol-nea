package Modelo;

import java.util.*;

public class Vuelo {
    private String numeroVuelo;
    private Asiento[] asientos;
    private Queue<Pasajero> listaEspera;

    public Vuelo(String numeroVuelo, int totalAsientos) {
        this.numeroVuelo = numeroVuelo;
        this.asientos = new Asiento[totalAsientos];
        for (int i = 0; i < totalAsientos; i++) {
            asientos[i] = new Asiento(i + 1);
        }
        this.listaEspera = new LinkedList<>();
    }

    public boolean reservarAsiento(Pasajero pasajero) {
        for (Asiento asiento : asientos) {
            if (!asiento.estaReservado()) {
                asiento.reservar(pasajero);
                return true;
            }
        }
        listaEspera.add(pasajero);
        return false;
    }

    public Asiento[] obtenerAsientos() {
        return asientos;
    }

    public Queue<Pasajero> obtenerListaEspera() {
        return listaEspera;
    }
}
