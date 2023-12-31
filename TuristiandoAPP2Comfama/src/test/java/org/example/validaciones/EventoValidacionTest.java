package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// import static org.junit.jupiter.api.Assertions.*;

class EventoValidacionTest {

    private EventoValidacion validacion;

    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new EventoValidacion();
        System.out.println("Iniciando prueba...");
    }

    @Test
    public void validarTituloFuncionaCorrectamente(){
        String tituloPrueba = "Teatro Comfama";
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarTitulo(tituloPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarTituloFuncionaIncorrectamente(){
        String tituloPrueba = "Teatro Comfama: La gran obra";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()->this.validacion.validarTitulo(tituloPrueba));
        Assertions.assertEquals(Mensaje.TITULO_INVALIDO_LOCAL.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarCostoFuncionaCorrectamente(){
        double costoPrueba = 10000;
        Boolean respuesta = Assertions.assertDoesNotThrow(() ->this.validacion.validarCostoPersona(costoPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCostoFuncionaIncorrectamenteValoresNegativos(){
        double costoPrueba = -10000;
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.validacion.validarCostoPersona(costoPrueba));
        Assertions.assertEquals(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarFormatoFechaFuncionaCorrectamente(){
        String fechaPrueba = "05/10/2004";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarFormato(fechaPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarFormatoFechaFuncionaIncorrectamente(){
        String fechaPrueba = "2004/10/05";
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->this.validacion.validarFormato(fechaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_FECHA_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarFechaFuncionaCorrectamente(){
        LocalDateTime fechaInicial = LocalDateTime.of(2023, 8, 17, 0, 0);
        LocalDateTime fechaFinal= LocalDateTime.of(2023, 8, 20, 0, 0);
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarFecha(fechaInicial, fechaFinal));
        Assertions.assertTrue(respuesta);

    }

    @Test
    public void validarFechaFuncionaIncorrectamente(){
        LocalDateTime fechaInicial = LocalDateTime.of(2023, 8, 17, 0, 0);
        LocalDateTime fechaFinal= LocalDateTime.of(2023, 8, 14, 0, 0);
        Exception respuesta =Assertions.assertThrows(Exception.class, ()-> this.validacion.validarFecha(fechaInicial, fechaFinal));
        Assertions.assertEquals(Mensaje.FECHA_INVALIDA.getMensaje(), respuesta.getMessage());
    }
}