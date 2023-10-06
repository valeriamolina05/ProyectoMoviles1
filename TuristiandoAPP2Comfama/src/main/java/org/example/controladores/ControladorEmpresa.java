package org.example.controladores;

import org.example.entidades.Empresa;
import org.example.servicios.ServicioEmpresa;

public class ControladorEmpresa {
    private Empresa empresa = new Empresa(); //valida datos de un nuevo usuario
    ServicioEmpresa servicioEmpresa = new ServicioEmpresa();

    public void RegistrarEmpresa(String nit, String nombre, String descripcion, Integer ubicacion){
        empresa.setNit(nit);
        empresa.setNombre(nombre);
        empresa.setUbicacion(ubicacion);
        empresa.setDescripcion(descripcion);
    }

}
