package com.fgiron.votosAuthServer.Config;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import com.fgiron.votosAuthServer.Repositories.Cuenta_usuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceDB implements UserDetailsService{
    
    @Autowired
    private Cuenta_usuarioRepository userRepository;

    public UserDetails loadUserByNIFAndPassword(String NIF_hash, String password_hash){
        Cuenta_usuario cuenta = userRepository.existeUsuario(NIF_hash.getBytes(), password_hash.getBytes());
        if(cuenta == null){
            throw new UsernameNotFoundException(NIF_hash);
        }
        return new Cuenta_usuarioPrincipal(cuenta);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Cuenta_usuario cuenta = userRepository.findById(Long.valueOf(id)).get();
        if (cuenta == null) {
            throw new UsernameNotFoundException(id);
        }
        return new Cuenta_usuarioPrincipal(cuenta);
    }

}
