package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaValidacionTest {

    private ReservaValidacion validacion;

    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new ReservaValidacion();
        System.out.println("Iniciando prueba...");
    }

    @Test
    public void validarFormatoFechaFuncionaCorrectamente(){
        String pruebaFecha = "05/10/2004";
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarFormato(pruebaFecha));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarFechaFuncionaIncorrectamente(){
        String pruebaFecha = "2004/10/05";
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->this.validacion.validarFormato(pruebaFecha));
        Assertions.assertEquals(Mensaje.FORMATO_FECHA_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNumeroPersonasFuncionaCorrectamente(){
        Integer personasPrueba = 2;
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarNumeroPersonas(personasPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNumeroPersonasFuncionaIncorrecto(){
        Integer personasPrueba = 6;
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarNumeroPersonas(personasPrueba));
        Assertions.assertEquals(Mensaje.NUMERO_PERSONAS_INVALIDO.getMensaje(), respuesta.getMessage());
    }
}