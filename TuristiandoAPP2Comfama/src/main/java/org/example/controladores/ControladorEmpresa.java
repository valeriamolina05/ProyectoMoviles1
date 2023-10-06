package org.example.controladores;

import org.example.Entidades.Empresa;
import org.example.Servicios.ServicioEmpresa;

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
