package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.time.LocalDate;

public class OfertaValidacion {

    protected Util util = new Util();

    public OfertaValidacion() {
    }

    public boolean validarTitulo(String titulo) throws Exception{
        if (titulo.length() > 20) {
            throw new Exception(Mensaje.TITULO_INVALIDO_LOCAL.getMensaje());
        } else {
            return true;
        }
    }

    public boolean validarFecha (LocalDate fechaInicio, LocalDate fechaFin) throws Exception{
        if (fechaInicio.isAfter(fechaFin)){
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        }else{
            return true;
        }
    }

    public Boolean validarFormato(String fechaFin) throws Exception {
        if (!util.validarExpresionRegular(fechaFin, "\\b(\\d{2})/(\\d{2})/(\\d{4})\\b")) {
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



}


