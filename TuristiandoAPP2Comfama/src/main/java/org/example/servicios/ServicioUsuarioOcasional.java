package org.example.servicios;

import org.example.entidades.Ocasional;
import org.example.modelos.ModeloOcasional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServicioUsuarioOcasional {

    private ModeloOcasional modeloOcasional = new ModeloOcasional();

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

    public void guardarDatosBd(Ocasional ocasional){

        try {
            conexion();

            modeloOcasional.setNombre(ocasional.getNombre());
            modeloOcasional.setDocumento(ocasional.getDocumento());
            modeloOcasional.setCorreo(ocasional.getCorreo());
            modeloOcasional.setContraseña(ocasional.getContraseña());
            modeloOcasional.setValorCuota(ocasional.getValorCuota());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloOcasional);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Registro Usuario Ocacional Exitoso!\n");

        }catch (Exception error){
            error.printStackTrace();

        }finally{
            cerrarConexion();
        }
    }

    public ModeloOcasional buscarOcasional(Integer id){
        conexion();
        ModeloOcasional modeloOcasional2;
        modeloOcasional2 = manejadorConexionEntidades.find(ModeloOcasional.class, id);
        cerrarConexion();
        return modeloOcasional2;
    }
}
