package org.example.servicios;

import org.example.entidades.Evento;
import org.example.modelos.ModeloEmpresaPrivada;
import org.example.modelos.ModeloEntidadCultural;
import org.example.modelos.ModeloEvento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServicioEvento {
    
    private ModeloEvento modeloEvento = new ModeloEvento();
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

    public void guardarDatosBd(Evento evento, Integer idECultural, Integer idEPrivada) {
        try {
            conexion();

            if (idECultural != null) {
                entidadCultural = manejadorConexionEntidades.find(ModeloEntidadCultural.class, idECultural);
            }
            if (idEPrivada != null) {
                empresaPrivada = manejadorConexionEntidades.find(ModeloEmpresaPrivada.class, idEPrivada);
            }

            modeloEvento.setDescripcion(evento.getDescripcion());
            modeloEvento.setFechaFin(evento.getFechaFin());
            modeloEvento.setFechaInicio(evento.getFechaInicio());
            modeloEvento.setTitulo(evento.getTitulo());
            modeloEvento.setCostoPersona(evento.getCostoPersona());
            modeloEvento.setCategoria(evento.getCategoriaEvento());
            modeloEvento.setUbicacion(evento.getUbicacion());
            modeloEvento.setEmpresaPrivada(empresaPrivada);
            modeloEvento.setEntidadCultural(entidadCultural);

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloEvento);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("¡Evento registrada con exito!\n");

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
