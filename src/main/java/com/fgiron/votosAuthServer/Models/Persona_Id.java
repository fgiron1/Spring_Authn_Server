/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fgiron.votosAuthServer.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

import lombok.Data;

/**
 *
 * @author fgiron
 */
@Data
@Embeddable
public class Persona_Id implements Serializable {
  
    @Column(name="id")
    private @GeneratedValue Long id_persona;

    @Column(name="NIF_hash")
    private String NIF_hash;

    public Persona_Id() {
    }

    public Persona_Id(String NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    public Persona_Id(Long id_persona, String NIF_hash) {
        this.id_persona = id_persona;
        this.NIF_hash = NIF_hash;
    }    
    
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNIF_hash() {
        return NIF_hash;
    }

    public void setNIF_hash(String NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    
    
}
