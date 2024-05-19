package Modelo;

public class Ruta {
    private String origen;
    private String destino;
    private int distancia;

    public Ruta(String origen, String destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String obtenerOrigen() {
        return origen;
    }

    public String obtenerDestino() {
        return destino;
    }

    public int obtenerDistancia() {
        return distancia;
    }
}
