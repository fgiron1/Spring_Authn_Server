/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fgiron.votosAuthServer.Models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;

/**
 *
 * @author fgiron
 */
public class Persona_Id implements Serializable {
    
    private @GeneratedValue Long id_persona;
    private byte[] NIF_hash;

    public Persona_Id() {
    }

    public Persona_Id(byte[] NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    public Persona_Id(Long id_persona, byte[] NIF_hash) {
        this.id_persona = id_persona;
        this.NIF_hash = NIF_hash;
    }

    
    
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public byte[] getNIF_hash() {
        return NIF_hash;
    }

    public void setNIF_hash(byte[] NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    
    
}
