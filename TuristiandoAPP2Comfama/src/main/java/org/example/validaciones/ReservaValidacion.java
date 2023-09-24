package org.example.validaciones;



import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.time.LocalDate;

public class ReservaValidacion {

    protected Util util = new Util();

    public ReservaValidacion() {
    }

    public boolean validarFormato(String fecha) throws Exception {
        if (!util.validarExpresionRegular(fecha,"\\b(\\d{2})/(\\d{2})/(\\d{4})\\b")){
            throw new Exception(Mensaje.FORMATO_FECHA_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }

    public boolean validarNumeroPersonas(Integer numeroPersonas)throws Exception{
        if (numeroPersonas > 4){
            throw new Exception(Mensaje.NUMERO_PERSONAS_INVALIDO.getMensaje());
        } else{
            return true;
        }
    }
}
