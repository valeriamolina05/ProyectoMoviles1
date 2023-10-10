package org.example.servicios;

import org.example.entidades.Oferta;
import org.example.modelos.ModeloEmpresaPrivada;
import org.example.modelos.ModeloEntidadCultural;
import org.example.modelos.ModeloOferta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServicioOfrerta {
    
    private ModeloOferta modeloOferta = new ModeloOferta();

    private ModeloEntidadCultural entidadCultural;
    private ModeloEmpresaPrivada empresaPrivada;
    private String persistenciaNombre;
    private EntityManagerFactory conexionEntidades;
    private EntityManager manejadorConexionEntidades;

    public void conexion() {
        // Nombre documento de la entidad configurada en el ORM
        this.persistenciaNombre = "conexionbd";
        // conexion con las entidades
        this.conexionEntidades = null;
        this.manejadorConexionEntidades = null;

        this.conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
        this.manejadorConexionEntidades = conexionEntidades.createEntityManager();
    }

    public void guardarDatosBd(Oferta oferta, Integer idECultural, Integer idEPrivada) {
        try {
            conexion();

            if (idECultural != null) {
                entidadCultural = manejadorConexionEntidades.find(ModeloEntidadCultural.class, idECultural);
            }
            if (idEPrivada != null) {
                empresaPrivada = manejadorConexionEntidades.find(ModeloEmpresaPrivada.class, idEPrivada);
            }

            modeloOferta.setDescripcion(oferta.getDescripcion());
            modeloOferta.setFechaFin(oferta.getFechaFin());
            modeloOferta.setFechaInicio(oferta.getFechaInicio());
            modeloOferta.setTitulo(oferta.getTitulo());
            modeloOferta.setCostoPersona(oferta.getCostoPersona());
            modeloOferta.setEmpresaPrivada(empresaPrivada);
            modeloOferta.setEntidadCultural(entidadCultural);

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloOferta);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Oferta registrada con exito!\n");

        } catch (Exception error) {
            error.printStackTrace();

        } finally {
            if (manejadorConexionEntidades != null) {
                manejadorConexionEntidades.close();
            }
            if (conexionEntidades != null) {
                manejadorConexionEntidades.close();
            }
        }
    }

}
