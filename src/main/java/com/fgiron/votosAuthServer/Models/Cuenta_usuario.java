package com.fgiron.votosAuthServer.Models;

import enums.VotoRealizado;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fgiron
 */
@Entity
@Table(name = "Cuentas_usuario")
public class Cuenta_usuario implements Serializable {
    
   private @Id @GeneratedValue Long id;
   
   @OneToOne(mappedBy = "id",
           targetEntity = Persona.class,
           optional = false)
   private Persona persona_fk;
   
   @Column(nullable = false)
   private byte[] password_hash;
   
   @Column(nullable = false)
   private ZonedDateTime instante_creacion;
   
   @Column(nullable = false)
   private VotoRealizado haVotado;

   //Una cuenta existe si y solamente si a su vez existe una persona asociada a esta.
    public Cuenta_usuario(Persona persona_fk, byte[] password_hash, ZonedDateTime instante_creacion, VotoRealizado haVotado) {
        this.persona_fk = persona_fk;
        this.password_hash = password_hash;
        this.instante_creacion = instante_creacion;
        this.haVotado = haVotado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(Persona persona_fk) {
        this.persona_fk = persona_fk;
    }

    public byte[] getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(byte[] password_hash) {
        this.password_hash = password_hash;
    }

    public ZonedDateTime getInstante_creacion() {
        return instante_creacion;
    }

    public void setInstante_creacion(ZonedDateTime instante_creacion) {
        this.instante_creacion = instante_creacion;
    }

    public VotoRealizado getHaVotado() {
        return haVotado;
    }

    public void setHaVotado(VotoRealizado haVotado) {
        this.haVotado = haVotado;
    }

    
   
   
    
}
