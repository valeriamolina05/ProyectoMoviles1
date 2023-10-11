package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.OcasionalValidacion;

public class Ocasional extends Usuario implements Ireporte {

    private Double valorCuota;

    private OcasionalValidacion validacion = new OcasionalValidacion();

    public Ocasional() {
    }

    public Ocasional(Integer id, String documento, String nombre, String correo, String contraseña, Double valorCuota) {
        super(id, documento, nombre, correo, contraseña);
        this.valorCuota = valorCuota;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Double valorCuota) {
        try {
            this.validacion.validarValorCuota(valorCuota);
            this.valorCuota = valorCuota;
        }catch (Exception error){
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    @Override
    public void registrar(String documento, String nombre, String correo, String contraseña) {
        setDocumento(documento);
        setNombre(nombre);
        setCorreo(correo);
        setContraseña(contraseña);
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
            " id='" + getId() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", contraseña='" + getContraseña() + "'" +
            ", valorCuota='" + getValorCuota() + "'" +
            "}";
    }

}
