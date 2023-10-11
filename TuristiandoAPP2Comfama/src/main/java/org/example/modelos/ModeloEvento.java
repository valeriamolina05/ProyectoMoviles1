package org.example.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Eventos")
public class ModeloEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String titulo;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaInicio;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaFin;

    @Column(nullable = true)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "entidad_cultural_id", nullable = true)
    private ModeloEntidadCultural entidadCultural;

    @ManyToOne
    @JoinColumn(name = "empresa_privada_id", nullable = true)
    private ModeloEmpresaPrivada empresaPrivada;

    private Double costoPersona;
    private String ubicacion;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getCostoPersona() {
        return this.costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        this.costoPersona = costoPersona;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ModeloEntidadCultural getEntidadCultural() {
        return this.entidadCultural;
    }

    public void setEntidadCultural(ModeloEntidadCultural entidadCultural) {
        this.entidadCultural = entidadCultural;
    }

    public ModeloEmpresaPrivada getEmpresaPrivada() {
        return this.empresaPrivada;
    }

    public void setEmpresaPrivada(ModeloEmpresaPrivada empresaPrivada) {
        this.empresaPrivada = empresaPrivada;
    }    
    
}
