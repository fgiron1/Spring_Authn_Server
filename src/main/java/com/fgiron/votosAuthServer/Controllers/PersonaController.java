package com.fgiron.votosAuthServer.Controllers;

import com.fgiron.votosAuthServer.Repositories.PersonaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fgiron
 */

@RestController
public class PersonaController {
    
    private final PersonaRepository repo;
    
    public PersonaController(PersonaRepository repo){
        this.repo = repo;
    }
    
}