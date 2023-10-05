package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfiliadoValidacionTest {

    private AfiliadoValidacion afiliadoValidacion;

    @BeforeEach
    public void configurarPruebas(){
        this.afiliadoValidacion = new AfiliadoValidacion();
    }

    @Test
    public void validarMensualidadCorrecto(){
        Integer costoPrueba = 10000;
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> {
            return this.afiliadoValidacion.validarCostoMensualidad(costoPrueba);
        });
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarMensualidadIncorrecto(){
        Integer costoPrueba = -10000;
        Exception respuesta = Assertions.assertThrows(Exception.class,() ->this.afiliadoValidacion.validarCostoMensualidad(costoPrueba));
        Assertions.assertEquals(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarCedulaInvitadoFucionaCorrecto(){
        String cedulaInvitadoPrueba = "2783722849";
        boolean respuesta = assertDoesNotThrow(()->this.afiliadoValidacion.validarCedulaInvitado(cedulaInvitadoPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCedulaInvitadoFucionaIncorrectoPorNumeroCaracteres(){
        String cedulaInvitadoPrueba = "83722849";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.afiliadoValidacion.validarCedulaInvitado(cedulaInvitadoPrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarCedulaInvitadoFucionaIncorrectoPorTipoDeCaracteres(){
        String cedulaInvitadoPrueba = "83722aa849";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.afiliadoValidacion.validarCedulaInvitado(cedulaInvitadoPrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(),respuesta.getMessage());
    }


}