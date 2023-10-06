package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;

public class ServicioEmpresa {
    public void guardarDatosBd(EmpresaPrivada empresaPrivada){
        // Nombre documento de la entidad configurada en el ORM
        String persistenciaNombre = "conexionbd";

        //conexion con las entidades

        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try {
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
            manejadorConexionEntidades =conexionEntidades.createEntityManager();
            ModeloEmpresaPrivada modeloEmpresaPrivada = new ModeloEmpresaPrivada();

            modeloEmpresaPrivada.setNombre(empresaPrivada.getNombre());
            modeloEmpresaPrivada.setDescripcion(empresaPrivada.getDescripcion());
            modeloEmpresaPrivada.setNit(empresaPrivada.getNit());
            modeloEmpresaPrivada.setUbicacion(empresaPrivada.getUbicacion());
            modeloEmpresaPrivada.setNombreRepresentante(empresaPrivada.getNombreRepresentante());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloEmpresaPrivada);
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

