package com.fgiron.votosAuthServer.Repositories;

import com.fgiron.votosAuthServer.Models.Oauth_token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Oauth_tokenRepository extends JpaRepository<Oauth_token, Long>  {
    

}
