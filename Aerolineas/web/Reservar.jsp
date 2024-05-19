<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*" %>
<%@page import="Modelo.SistemaAerolinea, Modelo.Vuelo, Modelo.Pasajero"%>
<%@page import="Modelo.*"%>

<%
    SistemaAerolinea sistemaAerolinea = new SistemaAerolinea();
    sistemaAerolinea.añadirVuelo("A123", 5);

    Vuelo vuelo = sistemaAerolinea.obtenerVuelo("A123");
    String mensaje = "";
    if (request.getParameter("reserva") != null) {
        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        Pasajero pasajero = new Pasajero(nombre, id);
        if (vuelo.reservarAsiento(pasajero)) {
            mensaje = "Reserva exitosa para " + nombre;
        } else {
            mensaje = "No hay asientos disponibles. " + nombre + " ha sido añadido a la lista de espera.";
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/Reservar.css"/>
        <title>Sistema de Reservación de Vuelos</title>
    </head>
    <body>
        
        <header>
            <nav>
                <input type="checkbox" />
                <span></span>
                <span></span>
                <div id="links">
                    <li><a href="Home.html">Casa</a></li>
                    <li><a href="#">Reservar</a></li>
                    <li><a href="Acerca-de.html">Acerca de</a></li>
                </div>
            </nav>
        </header>
        <main>
            <section>
                <h1>Sistema de Reservas de Aerolíneas</h1>
                <form method="post">
                    Nombre: <input type="text" name="nombre" required><br>
                    ID: <input type="text" name="id" required><br>
                    <input type="submit" name="reserva" value="Reservar">
                </form>
                <p><%= mensaje %></p>
                <h2>Asientos</h2>
                <ul>
                    <% for (Asiento asiento : vuelo.obtenerAsientos()) { %>
                        <li>Asiento <%= asiento.obtenerPasajero() == null ? "Disponible" : "Reservado por " + asiento.obtenerPasajero().obtenerNombre() %></li>
                    <% } %>
                </ul>
            </section>
            <aside>
                <h2>Lista de Espera</h2>
                <ul>
                    <% for (Pasajero pasajero : vuelo.obtenerListaEspera()) { %>
                        <li><%= pasajero.obtenerNombre() %></li>
                    <% } %>
                </ul>
            </aside>
        </main>
        <br>
        <footer>
            <p>Estructuras de Información 401<br />Universidad de Cundinamarca</p>
        </footer>
        
    </body>
</html>
