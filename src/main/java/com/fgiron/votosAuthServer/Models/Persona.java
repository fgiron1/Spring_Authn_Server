package com.fgiron.votosAuthServer.Models;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author fgiron
 */

@Entity
@Table(name="Personas")
public class Persona implements Serializable {
    
    @EmbeddedId
    @Column(name="id")
    private Persona_Id id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellidos;
    
    @Column(nullable = false)
    private LocalDate fecha_nacimiento;
    
    @Column(nullable = false)
    private String provincia;
    
    @Column(nullable = false)
    private String domicilio;

    public Persona() {
    }

    public Persona(Persona_Id id, String nombre, String apellidos, LocalDate fecha_nacimiento, String provincia, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.provincia = provincia;
        this.domicilio = domicilio;
    }

    
    public Persona(String nombre, String apellidos, LocalDate fecha_nacimiento, String provincia, String domicilio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.provincia = provincia;
        this.domicilio = domicilio;
    }

    
    
    public Persona_Id getId() {
        return id;
    }

    public void setId(Persona_Id id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
        
    
    
}
