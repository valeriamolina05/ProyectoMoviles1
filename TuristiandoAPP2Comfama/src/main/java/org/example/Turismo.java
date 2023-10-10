package org.example;

import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorEntidadCultural;
import org.example.controladores.ControladorOferta;
import org.example.controladores.ControladorUsuario;
// import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) {

        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.registrarUsuario("1234567890", "Sebastian Espitia Sanchez", "Sebas@gmail.com", 2);

        ControladorEmpresaPrivada controladorEPrivada = new ControladorEmpresaPrivada();
        controladorEPrivada.registrarEmpresa("1234567890", "BarnilSA", null, null, "Manuel Fernando", "1006868645" );

        ControladorEntidadCultural controladorEcultural = new ControladorEntidadCultural();
        controladorEcultural.registrarEmpresa("1029384756", "Sol", null, null, null, "manos verdes", "3129368570", "manosverdes@gmail.org");

        ControladorOferta controladorOferta = new ControladorOferta();
        controladorOferta.registrarOferta("2X1", null, null, null, 1000.0, 1, null);
        
    }
}