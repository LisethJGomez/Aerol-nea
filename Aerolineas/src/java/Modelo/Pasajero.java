package Modelo;

public class Pasajero {
    private String nombre;
    private String id;

    public Pasajero(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerId() {
        return id;
    }
}
