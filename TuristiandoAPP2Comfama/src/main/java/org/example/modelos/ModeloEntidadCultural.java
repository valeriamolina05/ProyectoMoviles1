package org.example.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entidades_Culturales")

public class ModeloEntidadCultural {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String nit;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String organizacion;

    
    private String descripcion;
    private String mision;
    private Integer ubicacion;
    private String telefono;
    private String correo;
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


    public String getOrganizacion() {
        return this.organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getMision() {
        return this.mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public Double getCobro() {
        return this.cobro;
    }

    public void setCobro(Double cobro) {
        this.cobro = cobro;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nit='" + getNit() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", organizacion='" + getOrganizacion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", mision='" + getMision() + "'" +
            ", ubicacion='" + getUbicacion() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", cobro='" + getCobro() + "'" +
            "}";
    }

}
