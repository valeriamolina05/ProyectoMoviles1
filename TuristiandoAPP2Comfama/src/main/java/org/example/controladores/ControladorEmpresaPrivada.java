package org.example.controladores;

import org.example.entidades.EmpresaPrivada;
import org.example.servicios.ServicioEmpresaPrivada;

public class ControladorEmpresaPrivada {
    private EmpresaPrivada empresaPrivada = new EmpresaPrivada();
    ServicioEmpresaPrivada servicioEmpresaPrivada = new ServicioEmpresaPrivada();

    public void RegistrarEmpresa(String nit, String nombre, String descripcion, Integer ubicacion, String nombreRepresentante){
        empresaPrivada.setNit(nit);
        empresaPrivada.setNombre(nombre);
        empresaPrivada.setUbicacion(ubicacion);
        empresaPrivada.setDescripcion(descripcion);
        empresaPrivada.setNombreRepresentante(nombreRepresentante);

        servicioEmpresaPrivada.guardarDatosBd(empresaPrivada);
    }

}
