package org.example;

import org.example.controladores.ControladorUsuario;
// import org.example.entidades.*;

// import java.time.LocalDate;
import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.registrarUsuario("1234567890", "Daniel Espitia Sanchez", "danieles@gmail.com", 2);
        lea.close();
    }
}