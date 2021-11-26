package com.fgiron.votosAuthServer.Controllers;

import com.fgiron.votosAuthServer.Models.Persona;
import com.fgiron.votosAuthServer.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fgiron
 */

@RestController
public class PersonaController {
    
    @Autowired
    private final PersonaRepository repo;
    
    public PersonaController(PersonaRepository repo){
        this.repo = repo;
    }
    
    @PostMapping("/persona/verificar")
    public boolean existePersona(@RequestBody byte[] NIF_hash,
                                @RequestBody byte[] nombre,
                                @RequestBody byte[] apellidos,
                                @RequestBody byte[] fecha_nacimiento, //Es un string convertido a bytes de formato dd/MM/yyyy
                                @RequestBody byte[] provincia,
                                @RequestBody byte[] domicilio){
        return repo.existePersona(NIF_hash, nombre, apellidos, fecha_nacimiento, provincia, domicilio);
    }
    
}