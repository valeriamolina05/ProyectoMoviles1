package org.example.controladores;

import org.example.entidades.EntidadCultural;
import org.example.modelos.ModeloEntidadCultural;
import org.example.servicios.ServicioEntidadCultural;

public class ControladorEntidadCultural {
    EntidadCultural entidadCultural = new EntidadCultural();
    ServicioEntidadCultural servicioEntidadCultural = new ServicioEntidadCultural();
    
    public void registrarEmpresa(String nit, String nombre, String descripcion, Integer ubicacion, String mision, String organizacion, String telefono, String correo ){
        entidadCultural.setNit(nit);
        entidadCultural.setNombre(nombre);
        entidadCultural.setUbicacion(ubicacion);
        entidadCultural.setDescripcion(descripcion);
        entidadCultural.setMision(mision);
        entidadCultural.setOrganizacion(organizacion);
        entidadCultural.setTelefono(telefono);
        entidadCultural.setCorreo(correo);
        entidadCultural.cobrar();

        servicioEntidadCultural.guardarDatosBd(entidadCultural);
    }

    public ModeloEntidadCultural buscarEntidadCultural(Integer id){
        return servicioEntidadCultural.buscarEntidadCultural(id);
    }
}
