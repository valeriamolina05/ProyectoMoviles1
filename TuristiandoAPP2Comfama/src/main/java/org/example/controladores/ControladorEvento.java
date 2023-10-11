package org.example.controladores;

import org.example.entidades.Evento;
import org.example.servicios.ServicioEvento;

public class ControladorEvento {
    Evento evento = new Evento();
    ServicioEvento servicioOfrerta = new ServicioEvento();

    public void registrarEvento(String titulo, String descripcion, String fechaInicio, String fechaFin,
            Double costoPersona, String categoria, String ubicacion, Integer idECultural, Integer idEPrivada) {

        evento.setTitulo(titulo);
        evento.setFechaInicio(fechaInicio);
        evento.setFechaFin(fechaFin);
        evento.setCostoPersona(costoPersona);
        evento.setCategoriaEvento(categoria);
        evento.setUbicacion(ubicacion);

        servicioOfrerta.guardarDatosBd(evento, idECultural, idEPrivada);
    }

}
