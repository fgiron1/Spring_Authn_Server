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
    
    private @GeneratedValue Long id;
    private byte[] NIF_hash;

    public Persona_Id() {
    }

    public Persona_Id(byte[] NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    public Persona_Id(Long id, byte[] NIF_hash) {
        this.id = id;
        this.NIF_hash = NIF_hash;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getNIF_hash() {
        return NIF_hash;
    }

    public void setNIF_hash(byte[] NIF_hash) {
        this.NIF_hash = NIF_hash;
    }
    
    
    
}
