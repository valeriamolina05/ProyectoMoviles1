package org.example.utilidades;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public boolean validarExpresionRegular(String cadena, String expresionregular){
        Pattern patron = Pattern.compile(expresionregular);
        Matcher coincidencia = patron.matcher(cadena);
        if (coincidencia.matches()){ //SI HAY COINCIDENCIA
            return true;
        }else{
           return false;
        }
    }

    public Integer generarId(){
        Integer idGenerado;
        idGenerado = (int) (Math.random() * 501);
        return idGenerado;
    }

    public double calcularIVA(double costoTotal) {
        return costoTotal * 0.19;
    }
}
