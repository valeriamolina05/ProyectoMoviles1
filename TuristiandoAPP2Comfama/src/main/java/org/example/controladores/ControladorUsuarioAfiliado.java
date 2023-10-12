package org.example.controladores;

import org.example.entidades.Afiliado;
import org.example.servicios.ServicioUsuarioAfiliado;

public class ControladorUsuarioAfiliado {
    Afiliado afiliado = new Afiliado();
    ServicioUsuarioAfiliado servicioUsuarioAfiliado = new ServicioUsuarioAfiliado();

    public void registrarUsuarioAfiliado(String documento, String nombre, String correo, String contraseña, Double valorMensualidad, String cedulaInvitado){
        afiliado.registrar(documento, nombre, correo, contraseña);
        afiliado.setValorMensualidad(valorMensualidad);
        afiliado.setCedulaInvitado(cedulaInvitado);

        this.servicioUsuarioAfiliado.guardarDatosBd(afiliado);
    }
}
