package org.example.entidades;

import org.example.utilidades.Util;
import org.example.validaciones.UsuarioValidacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Usuario {

    protected Util util = new Util();
    private Integer id;
    private String documento;
    private String nombres;
    private String correo;
    private Integer ubicacion;
    protected UsuarioValidacion validacion = new UsuarioValidacion();

    public Usuario() {
    }

    public Usuario(Integer id, String documento, String nombres, String correo, Integer ubicacion) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.correo = correo;
        this.ubicacion = ubicacion;
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


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
      try {
        this.validacion.validarNombres(nombres);
        this.nombres = nombres;
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


    //1.Registrarse en plataforma
    public abstract Boolean registrar();


}




