package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioValidacionTest {

    //crear un objeto de la clase que quiero probar
    private UsuarioValidacion validacion;

    //preparar las pruebas que vamos a realizar
    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new UsuarioValidacion();// Constructor vacío
        System.out.println("Iniciando prueba...");
    }

    //Programar pruebas unitarias
    @Test

    public void validarNombresFuncionaCorrectamente(){
        String nombrePrueba= "Valeria Molina Caro"; //Preparar
        Boolean respuesta = Assertions.assertDoesNotThrow(() ->this.validacion.validarNombres(nombrePrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNombreFuncionaIncorrectoNumeroCaracteres(){
        String nombrePrueba = "Valeria";
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->this.validacion.validarNombres(nombrePrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNombreFuncionaIncorrectoCaracteresInvalidos(){
        String nombrePrueba = "5555555555";
         Exception respuesta =Assertions.assertThrows(Exception.class, () -> this.validacion.validarNombres(nombrePrueba));
         Assertions.assertEquals(Mensaje.NOMBRE_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarCorreoFuncionaCorrectamente(){
        String correoPrueba = "valemolinac05@gmail.com";
        Boolean respuesta = Assertions.assertDoesNotThrow(() ->this.validacion.validarCorreo(correoPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCorreoFuncionaIncorrectoFormato(){
        String correoPrueba = "valeriamolina.com";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarCorreo(correoPrueba));
        Assertions.assertEquals(Mensaje.CORREO_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarUbicacionFuncionaCorrectamente(){
        Integer ubicacionPrueba =  4;
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.validacion.validarUbicacion(ubicacionPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarUbicacionFuncionaIncorrectamente(){
        Integer ubicacionPrueba = 6;
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarUbicacion(ubicacionPrueba));
        Assertions.assertEquals(Mensaje.UBICACION_INVALIDA.getMensaje(), respuesta.getMessage());
    }


}