package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.EntidadCulturalValidacion;

public class EntidadCultural extends Empresa implements Ireporte {

    private String nombreSecretaria;
    private String misionSecretaria;


    private EntidadCulturalValidacion validacion = new EntidadCulturalValidacion();
    @Override
    public Boolean cobrar() {
       return false;
        // Calcular el precio base + IVA - 10%
    }

    public EntidadCultural() {
    }

    public EntidadCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String nombreSecretaria, String misionSecretaria) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.nombreSecretaria = nombreSecretaria;
        this.misionSecretaria = misionSecretaria;
    }

    public String getNombreSecretaria() {
        return nombreSecretaria;
    }

    public void setNombreSecretaria(String nombreSecretaria) {
        try {
            this.validacion.validarNombreSecretaria(nombreSecretaria);
            this.nombreSecretaria = nombreSecretaria;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public String getMisionSecretaria() {
        return misionSecretaria;
    }

    public void setMisionSecretaria(String misionSecretaria) {
        try {
            this.validacion.validarMisionSecretaria(misionSecretaria);
            this.misionSecretaria = misionSecretaria;
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
