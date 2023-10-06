package org.example.modelos;

import jakarta.persistence.*;

import java.util.IdentityHashMap;

@Entity
@Table(name = "usuarios")

public class ModeloUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;
    @Column(name="documento", nullable = false, length = 20)
    private String documentos;
    private String nombres;
    private String correo;
    private Integer ubicaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(Integer ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
