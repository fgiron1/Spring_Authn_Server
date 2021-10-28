package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Persona;
import com.fgiron.votosAuthServer.Models.Persona_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author fgiron
 */
public interface PersonaRepository extends JpaRepository<Persona, Persona_Id>{
    
    //public boolean existePersona(Persona identidad);
    
}
