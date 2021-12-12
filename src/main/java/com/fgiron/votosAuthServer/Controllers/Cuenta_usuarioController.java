package com.fgiron.votosAuthServer.Controllers;

import java.util.Base64;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import com.fgiron.votosAuthServer.Repositories.Cuenta_usuarioRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fgiron
 */

@RestController
public class Cuenta_usuarioController {
    
    private final Cuenta_usuarioRepository repo;
    
    public Cuenta_usuarioController(Cuenta_usuarioRepository repo){
        this.repo = repo;
    }
    
    
    /*@PutMapping("/cuenta/{id}")
    public Cuenta_usuario actualizarCuenta(@RequestBody String password_hash, @PathVariable long id) throws Exception{
        return repo.findById(id)
                .map((Cuenta_usuario cuenta) -> {
                    cuenta.setPassword_hash(Base64.getDecoder().decode(password_hash));
                    return cuenta;
                }).orElseThrow(() -> new Exception("No se puede actualizar la cuenta"));
                
    }*/
    
    @PostMapping("/cuenta")
    public Cuenta_usuario insertarCuenta(@RequestBody Cuenta_usuario nuevaCuenta){
        return repo.save(nuevaCuenta);
    }
    
}
