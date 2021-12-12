package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fgiron
 */

public interface Cuenta_usuarioRepository extends JpaRepository<Cuenta_usuario, Long> {
    
    @Query( value = "SELECT id, id_persona, NIF_hash_personas, password_hash, instante_creacion, ha_votado FROM dbo.ExisteCuenta(:NIF_hash, :password_hash)", nativeQuery = true)
    //@Procedure(procedureName = "ExisteCuenta")
    public Cuenta_usuario existeUsuario(@Param("NIF_hash") String NIF_hash,
                                        @Param("password_hash") String password_hash);
    
}
