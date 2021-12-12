package com.fgiron.votosAuthServer.Models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author fgiron
 */
@Entity()
@Table(name = "Cuentas_usuario")
public class Cuenta_usuario implements Serializable {
    
   @Column(name="id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private Long id;
   
   @OneToOne(targetEntity = Persona.class,
   optional = false,
   fetch = FetchType.LAZY)
   @JoinColumns({//El nombre de las columnas en bbdd (tabla física Cuentas_usuario) que estarán relacionadas con la columna 
       @JoinColumn(name="id_persona", referencedColumnName = "id"),
       @JoinColumn(name="NIF_hash_personas", referencedColumnName = "NIF_hash")
   })
   @NotFound(action = NotFoundAction.IGNORE)
   private Persona id_persona;

   @Column(nullable = false)
   private String password_hash;
   
   @Column(nullable = false)
   private ZonedDateTime instante_creacion;
   
   @Column(nullable = false)
   private boolean ha_votado;

   //Una cuenta existe si y solamente si a su vez existe una persona asociada a esta.
    public Cuenta_usuario(Long id, Persona id_persona, String NIF_hash_personas, String password_hash, ZonedDateTime instante_creacion, boolean ha_votado) {
        this.id = id;
        this.id_persona = id_persona;
        this.id_persona.getId().setNIF_hash(NIF_hash_personas);
        this.password_hash = password_hash;
        this.instante_creacion = instante_creacion;
        this.ha_votado = ha_votado;
    }

    public Cuenta_usuario(){}

    public String getNIF_hash_personas(){
        return this.id_persona.getId().getNIF_hash();
    }

    public void setNIF_hash_personas(String NIF_hash_personas){
        this.id_persona.getId().setNIF_hash(NIF_hash_personas);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public ZonedDateTime getInstante_creacion() {
        return instante_creacion;
    }

    public void setInstante_creacion(ZonedDateTime instante_creacion) {
        this.instante_creacion = instante_creacion;
    }

    public boolean getHa_Votado() {
        return ha_votado;
    }

    public void setHa_Votado(boolean ha_votado) {
        this.ha_votado = ha_votado;
    }

    
   
   
    
}
