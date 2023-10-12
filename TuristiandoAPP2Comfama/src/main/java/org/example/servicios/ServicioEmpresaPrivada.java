package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;

public class ServicioEmpresaPrivada {

    private ModeloEmpresaPrivada modeloEmpresaPrivada = new ModeloEmpresaPrivada();

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

    public ModeloEmpresaPrivada buscarEmpresaPrivada(Integer id) {
        conexion();
        ModeloEmpresaPrivada modeloEmpresaPrivada2;
        modeloEmpresaPrivada2 = manejadorConexionEntidades.find(ModeloEmpresaPrivada.class, id);
        cerrarConexion();
        return modeloEmpresaPrivada2;
    }

}
