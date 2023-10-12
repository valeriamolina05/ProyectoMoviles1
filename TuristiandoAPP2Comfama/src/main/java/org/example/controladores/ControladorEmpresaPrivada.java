package org.example.controladores;

import org.example.entidades.EmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;
import org.example.servicios.ServicioEmpresaPrivada;

public class ControladorEmpresaPrivada {
    private EmpresaPrivada empresaPrivada = new EmpresaPrivada();
    private ServicioEmpresaPrivada servicioEmpresaPrivada = new ServicioEmpresaPrivada();

    public void registrarEmpresa(String nit, String nombre, String descripcion, Integer ubicacion, String nombreRepresentante, String cedulaRepresentante){
        empresaPrivada.setNit(nit);
        empresaPrivada.setNombre(nombre);
        empresaPrivada.setUbicacion(ubicacion);
        empresaPrivada.setDescripcion(descripcion);
        empresaPrivada.setNombreRepresentante(nombreRepresentante);
        empresaPrivada.setCedulaRepresentante(cedulaRepresentante);
        empresaPrivada.cobrar();

        servicioEmpresaPrivada.guardarDatosBd(empresaPrivada);
    }

    public ModeloEmpresaPrivada buscarEmpresaPrivada(Integer id){
        return servicioEmpresaPrivada.buscarEmpresaPrivada(id);
    }
}
