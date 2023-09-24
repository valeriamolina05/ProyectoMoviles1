package org.example.validaciones;

import org.example.utilidades.Mensaje;

public class OcasionalValidacion {

    public OcasionalValidacion() {
    }

    public boolean validarValorCuota(Integer valorCuota) throws Exception{
        if (valorCuota < 0){
            throw new Exception(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje());
        } else if (valorCuota > 200000) {
            throw new Exception(Mensaje.COSTO_CUOTA_INVALIDO.getMensaje());
        }else{
            return true;
        }
    }



}
