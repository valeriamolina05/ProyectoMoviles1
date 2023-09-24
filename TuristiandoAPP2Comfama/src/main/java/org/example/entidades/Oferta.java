package org.example.entidades;

import org.example.utilidades.Util;
import org.example.validaciones.OfertaValidacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Oferta {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected Util util = new Util();
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double costoPersona = 0.0;

    private Empresa local;
    protected OfertaValidacion validacion = new OfertaValidacion();

    public Oferta() {
    }

    public Oferta(Util util, Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Double costoPersona, Empresa local) {
        this.util = util;
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.local = local;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
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
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
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
        try {
            this.validacion.validarFormato(fechaInicio);
            this.fechaInicio = LocalDate.parse(fechaInicio,util.formatter);
        } catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
        }
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        try {
            this.validacion.validarFormato(fechaFin);
            this.validacion.validarFecha(getFechaInicio(), LocalDate.parse(fechaFin, util.formatter));
            this.fechaFin = LocalDate.parse(fechaFin, formatter);
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");

    }}

    public Double getCostoPersona() {
        return costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        try {
            this.validacion.validarCostoPersona(costoPersona);
            this.costoPersona = costoPersona;
        }catch (Exception error) {
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
    }}

    public Empresa getLocal() {
        return local;
    }

    public void setLocal(Empresa local) {
        this.local = local;
    }
}

