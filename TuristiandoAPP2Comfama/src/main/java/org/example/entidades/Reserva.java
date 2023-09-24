package org.example.entidades;

import org.example.utilidades.Util;
import org.example.validaciones.ReservaValidacion;

import java.time.LocalDate;

public class Reserva {
    protected Util util = new Util();
    private Integer id;
    private Usuario usuario;
    private Oferta oferta;
    private Double costoTotal = 0.0;
    private LocalDate fechaReserva;

    private Integer numeroPersonas =0;
    protected ReservaValidacion validacion = new ReservaValidacion();

    public Reserva() {
    }

    public Reserva(Integer id, Usuario usuario, Oferta oferta, Double costoTotal, LocalDate fechaReserva, Integer numeroPersonas) {
        this.id = id;
        this.usuario = usuario;
        this.oferta = oferta;
        this.costoTotal = costoTotal;
        this.fechaReserva = fechaReserva;
        this.numeroPersonas = numeroPersonas;
    }

    public Integer getId() {
        return id;
    }

    public void setId() {

        this.id = util.generarId();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal + (costoTotal * 0.19);
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {

        try {
            this.validacion.validarFormato(fechaReserva);
            this.fechaReserva = LocalDate.parse(fechaReserva, util.formatter);
        }catch (Exception error){
            System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
        }
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        try {
            this.validacion.validarNumeroPersonas(numeroPersonas);
            this.numeroPersonas = numeroPersonas;
        }catch (Exception error){
        System.out.println("\u001B[37m" + error.getMessage() +  "\u001B[0m");
    }
    }
}
