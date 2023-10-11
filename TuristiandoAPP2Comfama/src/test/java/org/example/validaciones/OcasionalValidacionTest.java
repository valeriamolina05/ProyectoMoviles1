package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

class OcasionalValidacionTest {

    private OcasionalValidacion ocasionalValidacion;

    @BeforeEach
    public void configurarPruebas(){
        this.ocasionalValidacion = new OcasionalValidacion();
    }

    @Test
    public void validarCostoCuotaCorrecto(){
        Double costoPrueba = 10000.00;
        Boolean respuesta = Assertions.assertDoesNotThrow(() ->this.ocasionalValidacion.validarValorCuota(costoPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCostoCuotaIncorrecto(){
        Double costoPrueba = -10000.00;
        Exception respuesta = Assertions.assertThrows(Exception.class,() ->this.ocasionalValidacion.validarValorCuota(costoPrueba));
        Assertions.assertEquals(Mensaje.COSTO_PERSONA_INVALIDO.getMensaje(), respuesta.getMessage());
    }

}