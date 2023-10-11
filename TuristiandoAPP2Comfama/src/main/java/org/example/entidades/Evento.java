package org.example.entidades;

import org.example.modelos.ModeloEmpresaPrivada;
import org.example.modelos.ModeloEntidadCultural;
import org.example.utilidades.Util;
import org.example.validaciones.EventoValidacion;

import java.time.LocalDateTime;

public class Evento {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double costoPersona;
    private String categoriaEvento;
    private String ubicacion;
    private ModeloEntidadCultural modeloEntidadCultural;
    private ModeloEmpresaPrivada modeloEmpresaPrivada;

    private Util util = new Util();
    private EventoValidacion validacion = new EventoValidacion();

    public Evento() {
    }

    public Evento(Integer id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
            Double costoPersona, String categoriaEvento, ModeloEntidadCultural modeloEntidadCultural,
            ModeloEmpresaPrivada modeloEmpresaPrivada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.categoriaEvento = categoriaEvento;
        this.modeloEntidadCultural = modeloEntidadCultural;
        this.modeloEmpresaPrivada = modeloEmpresaPrivada;
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio == null) {
            this.fechaInicio = LocalDateTime.of(1900, 1, 1, 0, 0);
        } else {
            try {
                this.validacion.validarFormato(fechaInicio);
                this.fechaInicio = LocalDateTime.parse(fechaInicio, util.formatter);
            } catch (Exception error) {
                System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        if (fechaFin == null) {
            this.fechaFin = LocalDateTime.of(1900, 1, 1, 0, 0);
        } else {
            try {
                this.validacion.validarFormato(fechaFin);
                this.validacion.validarFecha(getFechaInicio(), LocalDateTime.parse(fechaFin, util.formatter));
                this.fechaFin = LocalDateTime.parse(fechaFin, util.formatter);
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
        return this.modeloEntidadCultural;
    }

    public String getCategoriaEvento() {
        return this.categoriaEvento;
    }

    public void setCategoriaEvento(String categoriaEvento) {
        if (categoriaEvento == null) {
            this.categoriaEvento = "otros";
            return;
        } else {
            try {
                validacion.validarCategoria(categoriaEvento);
                this.categoriaEvento = categoriaEvento.toLowerCase();
            } catch (Exception error) {
                System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion == null) {
            this.ubicacion = "otro";
            return;
        } else {
            try {
                validacion.validarUbicacion(ubicacion);
                this.ubicacion = ubicacion.toLowerCase();
            } catch (Exception error) {
                System.out.println("\u001B[37m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

    public void setModeloEntidadCultural(ModeloEntidadCultural modeloEntidadCultural) {
        this.modeloEntidadCultural = modeloEntidadCultural;
    }

    public ModeloEmpresaPrivada getModeloEmpresaPrivada() {
        return this.modeloEmpresaPrivada;
    }

    public void setModeloEmpresaPrivada(ModeloEmpresaPrivada modeloEmpresaPrivada) {
        this.modeloEmpresaPrivada = modeloEmpresaPrivada;
    }

}
