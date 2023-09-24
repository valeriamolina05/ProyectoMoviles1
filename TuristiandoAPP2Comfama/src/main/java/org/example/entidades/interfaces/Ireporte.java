package org.example.entidades.interfaces;

public interface Ireporte {

    public void generarReporte();
    public void editarReporte(Integer id, String datosNuevos);
    public void buscarReporte(Integer id);
}
