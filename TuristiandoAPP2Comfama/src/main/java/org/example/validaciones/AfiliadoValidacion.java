package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

public class AfiliadoValidacion {
    protected Util util = new Util();

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

    public boolean validarCedulaInvitado ( String cedulaInvitado)throws Exception{
        if (cedulaInvitado.length() != 10){
            throw new Exception(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje());
        }else if (!util.validarExpresionRegular(cedulaInvitado,  "^[0-9]+$")) {
            throw new Exception(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje());

        }else{
            return true;
        }
    }







}
