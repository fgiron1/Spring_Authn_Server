/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author fgiron
 */

public interface Cuenta_usuarioRepository extends JpaRepository<Cuenta_usuario, Long> {
    
    @Query(value = "SELECT id, id_persona, NIF_hash_personas, password_hash, instante_creacion, haVotado FROM Cuentas_usuario WHERE NIF_hash_personas = :NIF_hash AND password_hash = :pwd_hash", nativeQuery = true)
    public Cuenta_usuario existeUsuario(@Param("NIF_hash") byte[] NIF_hash,
                                        @Param("pwd_hash") byte[] password_hash);
    
}
