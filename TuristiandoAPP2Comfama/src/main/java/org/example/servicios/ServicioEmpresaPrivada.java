package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;

public class ServicioEmpresaPrivada {

    private String persistenciaNombre;
    private EntityManagerFactory conexionEntidades;
    private EntityManager manejadorConexionEntidades;
    private ModeloEmpresaPrivada modeloEmpresaPrivada = new ModeloEmpresaPrivada();

    public void conexion(){
        // Nombre documento de la entidad configurada en el ORM
        this.persistenciaNombre = "conexionbd";
        //conexion con las entidades
        this.conexionEntidades = null;
        this.manejadorConexionEntidades = null;

        this.conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
        this.manejadorConexionEntidades = conexionEntidades.createEntityManager();
    }

    public void guardarDatosBd(EmpresaPrivada empresaPrivada){

        try {
            conexion();

            modeloEmpresaPrivada.setNit(empresaPrivada.getNit());
            modeloEmpresaPrivada.setNombre(empresaPrivada.getNombre());
            modeloEmpresaPrivada.setDescripcion(empresaPrivada.getDescripcion());
            modeloEmpresaPrivada.setNombreRepresentante(empresaPrivada.getNombreRepresentante());
            modeloEmpresaPrivada.setCedulaRepresentante(empresaPrivada.getCedulaRepresentante());
            modeloEmpresaPrivada.setUbicacion(empresaPrivada.getUbicacion());
            modeloEmpresaPrivada.setCobro(empresaPrivada.getCobro());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloEmpresaPrivada);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Empresa privada registrada con exito!\n");

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

}

