package org.example.validaciones;

import org.example.utilidades.Mensaje;

public class EntidadCulturalValidacion {

    public EntidadCulturalValidacion(){
    }

    public boolean validarNombreSecretaria(String nombreSecretaria) throws Exception{
        if (nombreSecretaria.length() > 70){
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_70.getMensaje());
        } else if (nombreSecretaria.length() <10) {
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_10.getMensaje());
        }else
            return true;
    }

    public boolean validarMisionSecretaria(String misionSecretaria)throws Exception{
        if (misionSecretaria.length() > 70){
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_70.getMensaje());
        } else if (misionSecretaria.length() <10) {
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_10.getMensaje());
        }else
            return true;
    }



}
