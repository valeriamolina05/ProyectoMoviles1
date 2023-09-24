package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaValidacionTest {

    private EmpresaValidacion validacion;

    @BeforeEach
    public void configurarPruebas(){ this.validacion = new EmpresaValidacion();
        System.out.println("Iniciando prueba...");
    }

    @Test
    public void validarNitFuncionaCorrectamente(){
        String nitPrueba = "1234567890";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarNit(nitPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNitFuncionaIncorrectamenteLongitud(){
        String nitPrueba = "1234";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.validacion.validarNit(nitPrueba));
        Assertions.assertEquals(Mensaje.NIT_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNitFuncionaIncorrectamentePorNumeros(){
        String nitPrueba = "vvvvvvvvvv";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.validacion.validarNit(nitPrueba));
        Assertions.assertEquals(Mensaje.NIT_NUMEROS_INVALIDOS.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNombreFuncionaCorrectamente(){
        String nombrePrueba = "Comfama";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarNombre(nombrePrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNombreFuncionaIncorrectamenteLongitud(){
        String nombrePrueba = "Comfamaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.NOMBRE_LOCAL_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNombreFuncionaIncorrectoPorCaracteres(){
        String nombrePrueba = "1234";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.NOMBRE_INVALIDO.getMensaje(), respuesta.getMessage());
    }

}