package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.Usuario;
import org.example.modelos.ModeloUsuario;
import java.util.List;

public class ServicioUsuario {
    private String persistenciaNombre;
    private EntityManagerFactory conexionEntidades;
    private EntityManager manejadorConexionEntidades;
    private ModeloUsuario modeloUsuario = new ModeloUsuario();

    public void conexion(){
        // Nombre documento de la entidad configurada en el ORM
        this.persistenciaNombre = "conexionbd";
        //conexion con las entidades
        this.conexionEntidades = null;
        this.manejadorConexionEntidades = null;

        this.conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
        this.manejadorConexionEntidades = conexionEntidades.createEntityManager();
    }

    public void guardarDatosBd(Usuario usuario){

        try {
            conexion();

            modeloUsuario.setNombre(usuario.getNombre());
            modeloUsuario.setDocumento(usuario.getDocumento());
            modeloUsuario.setCorreo(usuario.getCorreo());
            modeloUsuario.setUbicacion(usuario.getUbicacion());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloUsuario);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Registro Usuario Exitoso!\n");

        }catch (Exception error){
            error.printStackTrace();

        }finally{
            if(manejadorConexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
            if (conexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
        }

    }

    public List<ModeloUsuario> consultarDatosBd(Usuario usuario){

        try{
            conexion();
            String consulta = "SELECT modelousuario ModeloUsuario modelousuario";

            List<ModeloUsuario> usuarios = manejadorConexionEntidades.createQuery(consulta, ModeloUsuario.class).getResultList();
            return usuarios;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            conexionEntidades.close();
        }
    }

}
