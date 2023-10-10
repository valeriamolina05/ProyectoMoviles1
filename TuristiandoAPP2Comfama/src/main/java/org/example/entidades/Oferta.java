package org.example.entidades;

import org.example.modelos.ModeloEmpresaPrivada;
import org.example.modelos.ModeloEntidadCultural;
import org.example.utilidades.Util;
import org.example.validaciones.OfertaValidacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Oferta {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double costoPersona = 0.0;
    private ModeloEntidadCultural entidadCultural;
    private ModeloEmpresaPrivada empresaPrivada;

    private Util util = new Util();
    private OfertaValidacion validacion = new OfertaValidacion();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Oferta() {
    }

    public Oferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
            Double costoPersona, ModeloEntidadCultural entidadCultural, ModeloEmpresaPrivada empresaPrivada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.entidadCultural = entidadCultural;
        this.empresaPrivada = empresaPrivada;
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = util.generarId();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        try {
            this.validacion.validarTitulo(titulo);
            this.titulo = titulo;
        } catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio == null) {
            this.fechaInicio = LocalDate.of(1900, 1, 1);
        } else {
            try {
                this.validacion.validarFormato(fechaInicio);
                this.fechaInicio = LocalDate.parse(fechaInicio, util.formatter);
            } catch (Exception error) {
                System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        if (fechaFin == null) {
            this.fechaFin = LocalDate.of(1900, 1, 1);
        } else {
            try {
                this.validacion.validarFormato(fechaFin);
                this.validacion.validarFecha(getFechaInicio(), LocalDate.parse(fechaFin, util.formatter));
                this.fechaFin = LocalDate.parse(fechaFin, formatter);
            } catch (Exception error) {
                System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

    public Double getCostoPersona() {
        return costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        try {
            this.validacion.validarCostoPersona(costoPersona);
            this.costoPersona = costoPersona;
        } catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
        }
    }

    public ModeloEntidadCultural getModeloEntidadCultural() {
        return this.entidadCultural;
    }

    public void setModeloEntidadCultural(ModeloEntidadCultural entidadCultural) {
        this.entidadCultural = entidadCultural;
    }

    public ModeloEmpresaPrivada getModeloEmpresaPrivada() {
        return this.empresaPrivada;
    }

    public void setModeloEmpresaPrivada(ModeloEmpresaPrivada empresaPrivada) {
        this.empresaPrivada = empresaPrivada;
    }

}
