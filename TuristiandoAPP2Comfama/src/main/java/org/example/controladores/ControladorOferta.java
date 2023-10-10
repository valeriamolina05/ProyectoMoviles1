package org.example.controladores;

import org.example.entidades.Oferta;
import org.example.servicios.ServicioOfrerta;

public class ControladorOferta {
    Oferta oferta = new Oferta();
    ServicioOfrerta servicioOfrerta = new ServicioOfrerta();


    public void registrarOferta(String titulo, String descripcion, String fechaInicio, String fechaFin, Double costoPersona, Integer idECultural, Integer idEPrivada){

        oferta.setTitulo(titulo);
        oferta.setFechaFin(fechaFin);
        oferta.setFechaInicio(fechaInicio);
        oferta.setCostoPersona(costoPersona);

        servicioOfrerta.guardarDatosBd(oferta, idECultural, idEPrivada);
    }
    
}
