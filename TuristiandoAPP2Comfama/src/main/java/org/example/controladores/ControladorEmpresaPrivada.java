package org.example.controladores;

import org.example.entidades.EmpresaPrivada;
import org.example.servicios.ServicioEmpresa;

public class ControladorEmpresaPrivada {
    private EmpresaPrivada empresa = new EmpresaPrivada();
    ServicioEmpresa servicioEmpresa = new ServicioEmpresa();

    public void RegistrarEmpresa(String nit, String nombre, String descripcion, Integer ubicacion, String nombreRepresentante){
        empresa.setNit(nit);
        empresa.setNombre(nombre);
        empresa.setUbicacion(ubicacion);
        empresa.setDescripcion(descripcion);
        empresa.setNombreRepresentante(nombreRepresentante);
    }

}
