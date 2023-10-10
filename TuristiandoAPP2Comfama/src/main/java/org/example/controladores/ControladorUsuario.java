package org.example.controladores;

import org.example.entidades.Usuario;
import org.example.servicios.ServicioUsuario;
import org.example.modelos.ModeloUsuario;

import java.util.List;

public class ControladorUsuario {
    private Usuario usuario = new Usuario(); //valida datos de un nuevo usuario
    private ServicioUsuario servicioUsuario = new ServicioUsuario();

    public void registrarUsuario(String documento, String nombre, String correo, Integer ubicacion){
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setDocumento(documento);
        usuario.setUbicacion(ubicacion);
        this.servicioUsuario.guardarDatosBd(usuario);
    }

    public void consultarUsuario(){
        List<ModeloUsuario> usuarios = this.servicioUsuario.consultarDatosBd(usuario);
        System.out.println(usuarios);
    }

    /*public void consultarUsuario(){
    }*/
}
