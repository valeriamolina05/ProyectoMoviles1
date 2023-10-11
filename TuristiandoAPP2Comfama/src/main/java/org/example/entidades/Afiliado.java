package org.example.entidades;

import org.example.entidades.interfaces.Ireporte;
import org.example.validaciones.AfiliadoValidacion;

public class Afiliado extends Usuario implements Ireporte{

    private Integer valorMensualidad;
    private String cedulaInvitado;

    private AfiliadoValidacion validacion = new AfiliadoValidacion();

    public Afiliado() {
    }

    @Override
    public void registrar(String documento, String nombre, String correo, String contraseña) {
        setDocumento(documento);
        setNombre(nombre);
        setCorreo(correo);
        setContraseña(contraseña);
    }

    public Afiliado(Integer id, String documento, String nombre, String correo, String contraseña, Integer valorMensualidad, String cedulaInvitado) {
        super(id, documento, nombre, correo, contraseña);
        this.valorMensualidad = valorMensualidad;
    }

    public Integer getValorMensualidad() {
        return valorMensualidad;
    }

    public void setValorMensualidad(Integer valorMensualidad) {
        try {
            this.validacion.validarCostoMensualidad(valorMensualidad);
            this.valorMensualidad = valorMensualidad;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public String getCedulaInvitado() {
        return cedulaInvitado;
    }

    public void setCedulaInvitado(String cedulaInvitado) {
        this.cedulaInvitado = cedulaInvitado;
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


