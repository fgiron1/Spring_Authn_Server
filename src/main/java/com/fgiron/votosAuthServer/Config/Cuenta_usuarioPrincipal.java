package com.fgiron.votosAuthServer.Config;

import java.util.ArrayList;
import java.util.Collection;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Cuenta_usuarioPrincipal implements UserDetails{

    private Cuenta_usuario cuenta;
    private ArrayList<GrantedAuthority> authorities;

    public Cuenta_usuarioPrincipal(Cuenta_usuario cuenta) {
        
        this.cuenta = cuenta;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("votos.write"));
        this.authorities.add(new SimpleGrantedAuthority("votos_senado.write"));
        this.authorities.add(new SimpleGrantedAuthority("integrantes.read"));
        this.authorities.add(new SimpleGrantedAuthority("votos_partido.read"));
        this.authorities.add(new SimpleGrantedAuthority("elecciones.read"));
        this.authorities.add(new SimpleGrantedAuthority("tipos_eleccion.read"));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return new String(cuenta.getPassword_hash());
    }

    @Override
    public String getUsername() {
        return new String(String.valueOf(cuenta.getNIF_hash_personas()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !cuenta.getHa_Votado();
    }

}
