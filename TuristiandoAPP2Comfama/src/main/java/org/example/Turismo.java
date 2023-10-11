package org.example;

import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorEntidadCultural;
import org.example.controladores.ControladorEvento;
// import org.example.controladores.ControladorUsuario;
// import java.util.Scanner;
import org.example.controladores.ControladorUsuarioOcacional;

public class Turismo {
        public static void main(String[] args) {

        ControladorEmpresaPrivada controladorEPrivada = new ControladorEmpresaPrivada();
        controladorEPrivada.registrarEmpresa("1234567890", "BarnilSA", null, null, "Manuel Fernando", "1006868645");

        ControladorEntidadCultural controladorEcultural = new ControladorEntidadCultural();
        controladorEcultural.registrarEmpresa("1029384756", "Sol", null, null, null, "manos verdes", "3129368570", "manosverdes@gmail.org");

        ControladorEvento controladorEvento = new ControladorEvento();
        controladorEvento.registrarEvento("Siembra", null, "01/02/2022 09:06", "01/03/2022 09:06", 1000.0, null, null, 1, null);

        ControladorUsuarioOcacional controladorUsuarioOcacional = new ControladorUsuarioOcacional();
        controladorUsuarioOcacional.registrarUsuarioOcasional("10056868645", "Sebastian Espitia Sanchez", "Sebas@gmail.com", "C0ntr4s3ñ@", null);
    }
}