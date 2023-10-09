package org.example;

import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorUsuario;
// import org.example.entidades.*;

// import java.time.LocalDate;
import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        lea.close();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.registrarUsuario("1234567890", "Sebastian Espitia Sanchez", "danieles@gmail.com", 2);

        ControladorEmpresaPrivada controladorEPrivada = new ControladorEmpresaPrivada();
        controladorEPrivada.RegistrarEmpresa("1234567890", "BarnilSA", null, null, "Manuel Fernando");
        
    }
}