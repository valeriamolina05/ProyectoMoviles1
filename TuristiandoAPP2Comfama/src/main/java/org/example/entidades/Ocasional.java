package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.OcasionalValidacion;

public class Ocasional extends Usuario implements Ireporte {
    @Override
    public Boolean registrar() {
        return null;
    }

    private Integer valorCuota;
    private OcasionalValidacion validacion = new OcasionalValidacion();

    public Ocasional() {
    }

    public Ocasional(Integer id, String documento, String nombres, String correo, Integer ubicacion, Integer valorCuota) {
        super(id, documento, nombres, correo, ubicacion);
        this.valorCuota = valorCuota;
    }

    public Integer getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Integer valorCuota) {
        try {
            this.validacion.validarValorCuota(valorCuota);
            this.valorCuota = valorCuota;
        }catch (Exception error){
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
