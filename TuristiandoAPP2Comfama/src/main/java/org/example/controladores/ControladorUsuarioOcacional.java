package org.example.controladores;

import org.example.entidades.Ocasional;
import org.example.servicios.ServicioUsuarioOcasional;

public class ControladorUsuarioOcacional {
    Ocasional ocasional = new Ocasional();
    ServicioUsuarioOcasional servicioUsuarioOcasional = new ServicioUsuarioOcasional();

    public void registrarUsuarioOcasional(String documento, String nombre, String correo, String contraseña, Double valorCuota){
        ocasional.registrar(documento, nombre, correo, contraseña);
        ocasional.setValorCuota(valorCuota);

        this.servicioUsuarioOcasional.guardarDatosBd(ocasional);
    }
}
