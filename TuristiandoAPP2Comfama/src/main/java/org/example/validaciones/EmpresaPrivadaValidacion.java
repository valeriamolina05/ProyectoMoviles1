package org.example.validaciones;

import org.example.utilidades.Mensaje;

public class EmpresaPrivadaValidacion {

    public EmpresaPrivadaValidacion() {
    }

    public boolean validarNombreRepresentante(String nombreRepresentante) throws Exception {
        if (nombreRepresentante.length() > 70) {
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_70.getMensaje());
        } else if (nombreRepresentante.length() < 10) {
            throw new Exception(Mensaje.NOMBRE_INVALIDO_SECRETARIA_10.getMensaje());
        } else{
            return true;
        }
    }
}
