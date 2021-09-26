/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author fgiron
 */
public interface Cuenta_usuarioRepository extends JpaRepository<Cuenta_usuario, Long> {
    
    public List<Cuenta_usuario> getCuentasUsuario();
    public Cuenta_usuario getCuentaUsuarioById();
    public 
    
}
