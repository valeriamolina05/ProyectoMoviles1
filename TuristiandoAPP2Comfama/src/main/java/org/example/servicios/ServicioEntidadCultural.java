package org.example.servicios;

import org.example.entidades.EntidadCultural;
import org.example.modelos.ModeloEntidadCultural;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServicioEntidadCultural {
    
    private ModeloEntidadCultural modeloEntidadCultural = new ModeloEntidadCultural();

    private String persistenciaNombre;
    private EntityManagerFactory conexionEntidades;
    private EntityManager manejadorConexionEntidades;

    public void conexion(){
        // Nombre documento de la entidad configurada en el ORM
        this.persistenciaNombre = "conexionbd";
        //conexion con las entidades
        this.conexionEntidades = null;
        this.manejadorConexionEntidades = null;

        this.conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
        this.manejadorConexionEntidades = conexionEntidades.createEntityManager();
    }

    public void cerrarConexion() {
        if (this.manejadorConexionEntidades != null) {
            this.manejadorConexionEntidades.close();
        }
        if (this.conexionEntidades != null) {
            this.manejadorConexionEntidades.close();
        }
    }

    public void guardarDatosBd(EntidadCultural entidadCultural){
        try {
            conexion();
            modeloEntidadCultural.setNit(entidadCultural.getNit());
            modeloEntidadCultural.setNombre(entidadCultural.getNombre());
            modeloEntidadCultural.setOrganizacion(entidadCultural.getOrganizacion());
            modeloEntidadCultural.setTelefono(entidadCultural.getTelefono());
            modeloEntidadCultural.setCorreo(entidadCultural.getCorreo());
            modeloEntidadCultural.setUbicacion(entidadCultural.getUbicacion());
            modeloEntidadCultural.setDescripcion(entidadCultural.getDescripcion());
            modeloEntidadCultural.setCobro(entidadCultural.getCobro());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloEntidadCultural);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Entidad Cultural registrada con exito!\n");
            
        }catch (Exception error){
            error.printStackTrace();

        }finally{
            cerrarConexion();
        }
    }
    public ModeloEntidadCultural buscarEntidadCultural(Integer id){
        conexion();
        ModeloEntidadCultural modeloEntidadCultural2;
        modeloEntidadCultural2 = manejadorConexionEntidades.find(ModeloEntidadCultural.class, id);
        cerrarConexion();
        return modeloEntidadCultural2;
    }
}
