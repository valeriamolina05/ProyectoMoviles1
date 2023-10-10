package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.EntidadCulturalValidacion;

public class EntidadCultural extends Empresa implements Ireporte {

    private String organizacion;
    private String mision;
    private String telefono;
    private String correo;
    private Double cobro;

    private EntidadCulturalValidacion validacion = new EntidadCulturalValidacion();

    public EntidadCultural() {
    }

    public EntidadCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String mision, String organizacion, String telefono, String correo) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.mision = mision;
        this.organizacion = organizacion;
        this.telefono = telefono;
        this.correo = correo;
        this.cobro = getCobro();
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        try {
            this.validacion.validarOrganizacion(organizacion);
            this.organizacion = organizacion;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        try {
            this.validacion.validarMision(mision);
            this.mision = mision;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void cobrar() {
        this.cobro = 1200000 + (1200000 * 0.19) - (1200000 * 0.1);
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
}
