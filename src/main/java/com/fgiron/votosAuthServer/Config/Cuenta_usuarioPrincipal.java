package com.fgiron.votosAuthServer.Config;

import java.util.Collection;

import com.fgiron.votosAuthServer.Models.Cuenta_usuario;
import com.fgiron.votosAuthServer.enums.VotoRealizado;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Cuenta_usuarioPrincipal implements UserDetails{

    private Cuenta_usuario cuenta;

    public Cuenta_usuarioPrincipal(Cuenta_usuario cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return new String(cuenta.getPassword_hash());
    }

    @Override
    public String getUsername() {
        return new String(String.valueOf(cuenta.getPersona_fk()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        VotoRealizado haVotado = cuenta.getHaVotado();
        return haVotado == VotoRealizado.SI;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

}
