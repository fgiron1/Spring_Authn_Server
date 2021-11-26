package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Persona;
import com.fgiron.votosAuthServer.Models.Persona_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 *
 * @author fgiron
 */
public interface PersonaRepository extends JpaRepository<Persona, Persona_Id>{
    
    //@Query("EXECUTE dbo.VerificarPersona @NIF_hash = ?1, @nombre = ?2, @apellidos = ?3, @fecha_nacimiento = ?4, @provincia = ?5, @domicilio = ?6")
    @Procedure(procedureName = "VerificarPersona")
    public boolean existePersona(byte[] NIF_hash,
                                byte[] nombre,
                                byte[] apellidos,
                                byte[] fecha_nacimiento, //Es un string convertido a bytes de formato dd/MM/yyyy
                                byte[] provincia,
                                byte[] domicilio);
    
}
