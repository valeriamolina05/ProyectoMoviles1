package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.EmpresaPrivadaValidacion;

public class EmpresaPrivada extends Empresa implements Ireporte {

    private String nombreRepresentante;
    @Override
    public Boolean cobrar() {
        return false;
    }

    private EmpresaPrivadaValidacion validacion = new EmpresaPrivadaValidacion();

    public EmpresaPrivada() {
    }

    public EmpresaPrivada(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String nombreRepresentante) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        try {
            this.validacion.validarNombreRepresentante(nombreRepresentante);
            this.nombreRepresentante = nombreRepresentante;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    @Override
    public void generarReporte() {

    }

    @Override
    public void editarReporte(Integer id, String datosNuevos) {

    }

    @Override
    public void buscarReporte(Integer id) {

    }
}
