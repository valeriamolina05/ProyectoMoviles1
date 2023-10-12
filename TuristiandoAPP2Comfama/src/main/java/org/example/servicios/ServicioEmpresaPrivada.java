package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import org.example.entidades.EmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;

public class ServicioEmpresaPrivada {

    private ModeloEmpresaPrivada modeloEmpresaPrivada = new ModeloEmpresaPrivada();

    private String persistenciaNombre;
    private EntityManagerFactory conexionEntidades;
    private EntityManager manejadorConexionEntidades;

    public void conexion() {
        // Nombre nit de la entidad configurada en el ORM
        this.persistenciaNombre = "conexionbd";
        // conexion con las entidades
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

    public void guardarDatosBd(EmpresaPrivada empresaPrivada) {

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

        } catch (Exception error) {
            error.printStackTrace();

        } finally {
            cerrarConexion();
        }
    }

    public ModeloEmpresaPrivada buscarEmpresaPrivada(String nit) {
        conexion();
        ModeloEmpresaPrivada modeloEmpresaPrivada2;
        TypedQuery<ModeloEmpresaPrivada> query = manejadorConexionEntidades.createQuery("SELECT ep FROM ModeloEmpresaPrivada ep WHERE ep.nit = :nit", ModeloEmpresaPrivada.class);
        query.setParameter("nit", nit);
        modeloEmpresaPrivada2 = query.getSingleResult();
        cerrarConexion();
        return modeloEmpresaPrivada2;
    }

}
