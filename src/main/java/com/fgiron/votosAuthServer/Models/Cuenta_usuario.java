package com.fgiron.votosAuthServer.Models;

import com.fgiron.votosAuthServer.enums.VotoRealizado;
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
@Entity()
@Table(name = "Cuentas_usuario")
public class Cuenta_usuario implements Serializable {
    
   //@Column(name="id")
   private @Id @GeneratedValue Long id;
   
   @OneToOne(targetEntity = Persona.class,
           optional = false)
   private Persona id_persona;
   
   @Column(nullable = false)
   private byte[] NIF_hash_personas;

   @Column(nullable = false)
   private byte[] password_hash;
   
   @Column(nullable = false)
   private ZonedDateTime instante_creacion;
   
   @Column(nullable = false)
   private boolean haVotado;

   //Una cuenta existe si y solamente si a su vez existe una persona asociada a esta.
    public Cuenta_usuario(Long id, Persona id_persona, byte[] NIF_hash_personas, byte[] password_hash, ZonedDateTime instante_creacion, boolean haVotado) {
        this.id = id;
        this.id_persona = id_persona;
        this.NIF_hash_personas = NIF_hash_personas;
        this.password_hash = password_hash;
        this.instante_creacion = instante_creacion;
        this.haVotado = haVotado;
    }

    public Cuenta_usuario(){}

    public byte[] getNIF_hash_personas(){
        return this.NIF_hash_personas;
    }

    public void setNIF_hash_personas(byte[] NIF_hash_personas){
        this.NIF_hash_personas = NIF_hash_personas;
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

    public boolean getHaVotado() {
        return haVotado;
    }

    public void setHaVotado(boolean haVotado) {
        this.haVotado = haVotado;
    }

    
   
   
    
}
