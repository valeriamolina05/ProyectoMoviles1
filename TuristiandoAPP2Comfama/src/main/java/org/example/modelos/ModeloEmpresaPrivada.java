package org.example.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresas_Privadas")
public class ModeloEmpresaPrivada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String nit;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nombreRepresentante;

    @Column(nullable = false)
    private String cedulaRepresentante;

    private Integer ubicacion;
    private String descripcion;
    private Double cobro;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRepresentante() {
        return this.nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public Double getCobro() {
        return this.cobro;
    }

    public void setCobro(Double cobro) {
        this.cobro = cobro;
    }

    public String getCedulaRepresentante() {
        return this.cedulaRepresentante;
    }

    public void setCedulaRepresentante(String cedulaRepresentante) {
        this.cedulaRepresentante = cedulaRepresentante;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nit='" + getNit() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", nombreRepresentante='" + getNombreRepresentante() + "'" +
            ", cedulaRepresentante='" + getCedulaRepresentante() + "'" +
            ", ubicacion='" + getUbicacion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", cobro='" + getCobro() + "'" +
            "}";
    }

}
