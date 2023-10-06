package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.Empresa;
import org.example.modelos.ModelosEmpresa;

public class ServicioEmpresa {
    public void guardarDatosBd(Empresa empresa){
        // Nombre documento de la entidad configurada en el ORM
        String persistenciaNombre = "conexionbd";

        //conexion con las entidades

        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try {
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
            manejadorConexionEntidades =conexionEntidades.createEntityManager();
            ModelosEmpresa modelosEmpresa = new ModelosEmpresa();

            modelosEmpresa.setNombre(empresa.getNombre());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modelosEmpresa);
            manejadorConexionEntidades.getTransaction().commit();

        }catch (Exception error){
            error.getStackTrace();

        }finally{
            if(manejadorConexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
            if (conexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
        }

    }

}

