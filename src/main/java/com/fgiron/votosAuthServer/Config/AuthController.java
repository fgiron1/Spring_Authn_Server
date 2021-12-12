package com.fgiron.votosAuthServer.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fgiron.votosAuthServer.Config.Jwt.JwtHelper;
import com.fgiron.votosAuthServer.Models.Oauth_token;
import com.fgiron.votosAuthServer.Repositories.Oauth_tokenRepository;
import com.fgiron.votosAuthServer.Config.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class AuthController {
    
	@Autowired
    private final JwtHelper jwtHelper;

	@Autowired
	private final UserDetailServiceDB userDetailService;

	@Autowired
	private Oauth_tokenRepository tokenStore;
	
	
	public AuthController(JwtHelper jwtHelper, UserDetailServiceDB userDetailService, Oauth_tokenRepository tokenStore) {
		this.jwtHelper = jwtHelper;
		this.userDetailService = userDetailService;
		this.tokenStore = tokenStore;
	}
	
	@PostMapping(path = "login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public LoginResult login(
			@RequestParam String NIF_hash,
			@RequestParam String password_hash) {
		
		Cuenta_usuarioPrincipal userDetails;

		//Reemplazamos el carácter '%2b' por '+'.
		//En la petición, se ha empleado %2b en lugar de + dado que este último
		//se codifica como un whitespace para el media type de application/x-www-form-urlencoded

		NIF_hash = NIF_hash.replace("%2b", "+");
		NIF_hash = NIF_hash.replace(" ", "+");

		password_hash = password_hash.replace("%2b", "+");
		password_hash = password_hash.replace(" ", "+");

		try {
            //Carga los usuarios por DNI_hash. Debería ser DNI + id porque los DNI se repiten
			userDetails = userDetailService.loadUserByNIFAndPassword(NIF_hash, password_hash);
		} catch (UsernameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
		}
		
		if (password_hash.equals(userDetails.getPassword())) {
			Map<String, String> claims = new HashMap<>();
			claims.put("username", NIF_hash);
			
			String authorities = userDetails.getAuthorities().stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.joining(","));
			claims.put("scope", authorities);
			claims.put("userId", String.valueOf(1));
			
			String jwt = jwtHelper.createJwtForClaims(NIF_hash, claims);

			//Persistir token en base de datos Identidades
			Oauth_token token = new Oauth_token(jwt, null);
			tokenStore.save(token);

			//FALSO ERROR DE SINTAXIS
			return new LoginResult(jwt);
		}
		
		throw new ResponseStatusException(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, "User not authenticated");
	}

	/*@PostMapping(path = "registro", consumes= {MediaType.APPLICATION_JSON})
	public SignupResult registro(@RequestBody String NIF_hash,
								@RequestBody String password_hash){

	}*/


}
