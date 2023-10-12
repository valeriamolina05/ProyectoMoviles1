package org.example.servicios;

import org.example.entidades.Afiliado;
import org.example.modelos.ModeloAfiliado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServicioUsuarioAfiliado {

    private ModeloAfiliado modeloAfiliado = new ModeloAfiliado();

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

    public void guardarDatosBd(Afiliado afiliado){

        try {
            conexion();

            modeloAfiliado.setNombre(afiliado.getNombre());
            modeloAfiliado.setDocumento(afiliado.getDocumento());
            modeloAfiliado.setCorreo(afiliado.getCorreo());
            modeloAfiliado.setContraseña(afiliado.getContraseña());
            modeloAfiliado.setValorMensualidad(afiliado.getValorMensualidad());
            modeloAfiliado.setCedulaInvitado(afiliado.getCedulaInvitado());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloAfiliado);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Registro Usuario Afiliado Exitoso!\n");

        }catch (Exception error){
            error.printStackTrace();

        }finally{
            cerrarConexion();
        }
    }

    public ModeloAfiliado buscarAfiliado(Integer id){
        conexion();
        ModeloAfiliado modeloAfiliado2;
        modeloAfiliado2 = manejadorConexionEntidades.find(ModeloAfiliado.class, id);
        cerrarConexion();
        return modeloAfiliado2;
    }

}
