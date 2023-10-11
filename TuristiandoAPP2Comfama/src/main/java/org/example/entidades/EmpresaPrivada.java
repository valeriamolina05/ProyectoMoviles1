package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.EmpresaPrivadaValidacion;

public class EmpresaPrivada extends Empresa implements Ireporte {

    private String nombreRepresentante;
    private String cedulaRepresentante;
    private Double cobro;

    private EmpresaPrivadaValidacion validacion = new EmpresaPrivadaValidacion();

    public EmpresaPrivada() {
    }

    public EmpresaPrivada(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String nombreRepresentante, String cedulaRepresentante) {
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

    public String getCedulaRepresentante() {
        return this.cedulaRepresentante;
    }

    public void setCedulaRepresentante(String cedulaRepresentante) {
        this.cedulaRepresentante = cedulaRepresentante;
    }

    @Override
    public void cobrar() {
        this.cobro = 2200000 + (2200000 * 0.19);
    }
        
    public Double getCobro() {
        return this.cobro;
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

    @Override
    public String toString() {
        return "{" +
            " nombreRepresentante='" + getNombreRepresentante() + "'" +
            ", cedulaRepresentante='" + getCedulaRepresentante() + "'" +
            ", cobro='" + getCobro() + "'" +
            "}";
    }

}
