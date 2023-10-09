package org.example.modelos;

import org.example.entidades.EmpresaPrivada;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresas_Privadas")
public class ModeloEmpresaPrivada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEPrivada")
    private Integer id;
    @Column(name = "nit", nullable = false, length = 10)
    private String nit;
    @Column(nullable = false)
    private String nombre;
    private Integer ubicacion;
    private String descripcion;
    private String nombreRepresentante;
    private Double cobro;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRepresentante() {
        return this.nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public Double getCobro() {
        return this.cobro;
    }

    public void setCobro(Double cobro) {
        this.cobro = cobro;
    }

    
}
