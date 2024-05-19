package Modelo;

public class Asiento {
    private int numero;
    private boolean reservado;
    private Pasajero pasajero;

    public Asiento(int numero) {
        this.numero = numero;
        this.reservado = false;
        this.pasajero = null;
    }

    public void reservar(Pasajero pasajero) {
        this.reservado = true;
        this.pasajero = pasajero;
    }

    public boolean estaReservado() {
        return reservado;
    }

    public Pasajero obtenerPasajero() {
        return pasajero;
    }
}
