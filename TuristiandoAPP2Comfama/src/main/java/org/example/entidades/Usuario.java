package org.example.entidades;

import org.example.utilidades.Util;
import org.example.validaciones.UsuarioValidacion;

public abstract class Usuario {

    private Integer id;
    private String documento;
    private String nombre;
    private String correo;
    private String contraseña;
    private Integer ubicacion;

    private Util util = new Util();
    private UsuarioValidacion validacion = new UsuarioValidacion();

    public Usuario() {
    }

    public Usuario(Integer id, String documento, String nombre, String correo, String contraseña) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = util.generarId();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento)  {
            this.documento = documento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
      try {
        this.validacion.validarNombre(nombre);
        this.nombre = nombre;
      }catch (Exception error){
          System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
      }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        try {
            this.validacion.validarCorreo(correo);
            this.correo = correo;
        }catch (Exception error){
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
        }
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
       try {
           this.validacion.validarUbicacion(ubicacion);
           this.ubicacion = ubicacion;
       }catch (Exception error){
           System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
       }
    }

    public abstract void registrar(String documento, String nombre, String email, String contraseña);
}




