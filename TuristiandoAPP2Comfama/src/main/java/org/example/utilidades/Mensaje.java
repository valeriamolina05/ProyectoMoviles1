package org.example.utilidades;

public enum Mensaje {

    NUMERO_CARACTERES_INVALIDO("El número de caracteres ingresados es incorrecto."),
    NOMBRE_INVALIDO("Por favor, ingresa solo letras en el nombre."),
    CORREO_INVALIDO("Revisa el formato del correo electrónico, por favor."),
    UBICACION_INVALIDA("La ubicación debe ser un número entre 1 y 4."),

    NIT_INVALIDO("El NIT debe tener exactamente 10 dígitos."),
    NIT_NUMEROS_INVALIDOS("El NIT solo puede contener números."),
    NOMBRE_LOCAL_INVALIDO("El nombre del local debe tener como máximo 30 caracteres."),

    TITULO_INVALIDO_LOCAL("El título no puede superar los 20 caracteres."),
    FECHA_INVALIDA("La fecha de inicio no puede ser posterior a la fecha de fin."),
    FORMATO_FECHA_INVALIDO("La fecha debe tener el formato 'dd/MM/yyyy'."),
    COSTO_PERSONA_INVALIDO("El costo por persona no puede ser negativo."),

    NUMERO_PERSONAS_INVALIDO("El número de personas es inválido. Solo se permite un máximo de 4 personas."),

    NOMBRE_INVALIDO_SECRETARIA_70("El número maximo de carácteres permitidos es 70"),

    NOMBRE_INVALIDO_SECRETARIA_10("El número minimo de carácteres permitidos es 10"),
    COSTO_CUOTA_INVALIDO("El valor de la cuota no debe superar el monto de 200.0000"),
    COSTO_MENSUALIDAD_INVALIDO("El valor de la mensualidad no debe superar el monto de 100.000");


    private String mensaje;

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
