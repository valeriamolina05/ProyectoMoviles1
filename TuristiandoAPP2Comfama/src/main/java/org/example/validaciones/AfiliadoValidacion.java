package org.example.validaciones;

import org.example.utilidades.Mensaje;

public class AfiliadoValidacion {

    //Validar costo mensualidad


    public AfiliadoValidacion() {
    }

    public boolean validarCostoMensualidad(Integer valorMensual) throws Exception{
        if (valorMensual < 0){
            throw new Exception(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje());
        } else if (valorMensual > 100000) {
            throw new Exception(Mensaje.COSTO_MENSUALIDAD_INVALIDO.getMensaje());
        }else {
            return true;
        }

    }







}
