package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.time.LocalDateTime;

public class EventoValidacion {

    protected Util util = new Util();

    public EventoValidacion() {
    }

    public boolean validarTitulo(String titulo) throws Exception {
        if (titulo.length() > 20) {
            throw new Exception(Mensaje.TITULO_INVALIDO_LOCAL.getMensaje());
        } else {
            return true;
        }
    }

    public boolean validarFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws Exception {
        if (fechaInicio == null || fechaInicio.isAfter(fechaFin)) {
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        } else {
            return true;
        }
    }

    public Boolean validarFormato(String fechaFin) throws Exception {
        if (!util.validarExpresionRegular(fechaFin, "\\b(\\d{2})/(\\d{2})/(\\d{4})\\s(\\d{2}):(\\d{2})\\b")) {
            throw new Exception(Mensaje.FORMATO_FECHA_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }

    public boolean validarCostoPersona(double costoPersona) throws Exception {

        if (costoPersona < 0) {
            throw new Exception(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }

    public boolean validarCategoria(String categoriaEvento) throws Exception {
        categoriaEvento = categoriaEvento.toLowerCase();
        if (categoriaEvento.equals("arte y cultura") ||
                categoriaEvento.equals("musica y conciertos") ||
                categoriaEvento.equals("teatro") ||
                categoriaEvento.equals("biblioteca") ||
                categoriaEvento.equals("otros")) {
            return true;
        } else {
            throw new Exception(Mensaje.CATEGORIA_INVALIDA.getMensaje());
        }
    }

    public boolean validarUbicacion(String ubicacion) throws Exception {
        ubicacion = ubicacion.toLowerCase();
        if (ubicacion.equals("rural") ||
                ubicacion.equals("urbana") ||
                ubicacion.equals("centro") ||
                ubicacion.equals("otro")) {
            return true;
        } else {
            throw new Exception("La ubicación no es válida.");
        }
    }

}
