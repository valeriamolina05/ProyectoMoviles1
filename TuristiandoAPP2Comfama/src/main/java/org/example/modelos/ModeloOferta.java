package org.example.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ofertas")
public class ModeloOferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String titulo;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "entidad_cultural_id", nullable = true)
    private ModeloEntidadCultural entidadCultural;

    @ManyToOne
    @JoinColumn(name = "empresa_privada_id", nullable = true)
    private ModeloEmpresaPrivada empresaPrivada;

    private Double costoPersona;

    public ModeloOferta() {
    }

    public ModeloOferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ModeloEntidadCultural entidadCultural, ModeloEmpresaPrivada empresaPrivada, Double costoPersona) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entidadCultural = entidadCultural;
        this.empresaPrivada = empresaPrivada;
        this.costoPersona = costoPersona;
    }

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

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getCostoPersona() {
        return this.costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        this.costoPersona = costoPersona;
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
