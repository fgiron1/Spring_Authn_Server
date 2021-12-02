package com.fgiron.votosAuthServer.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fgiron.votosAuthServer.Config.Jwt.JwtHelper;
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
	
	
	public AuthController(JwtHelper jwtHelper, UserDetailServiceDB userDetailService) {
		this.jwtHelper = jwtHelper;
		this.userDetailService = userDetailService;
	}
	
	@PostMapping(path = "login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public LoginResult login(
			@RequestParam String NIF_hash,
			@RequestParam String password_hash) {
		
		UserDetails userDetails;
		try {
            //Carga los usuarios por DNI_hash. Debería ser DNI + id porque los DNI se repiten
			userDetails = userDetailService.loadUserByNIFAndPassword(NIF_hash, password_hash);
		} catch (UsernameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
		}
		
		if (new BCryptPasswordEncoder().matches(password_hash, userDetails.getPassword())) {
			Map<String, String> claims = new HashMap<>();
			claims.put("username", NIF_hash);
			
			String authorities = userDetails.getAuthorities().stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.joining(","));
			claims.put("authorities", authorities);
			claims.put("userId", String.valueOf(1));
			
			String jwt = jwtHelper.createJwtForClaims(NIF_hash, claims);
			//FALSO ERROR DE SINTAXIS
			return new LoginResult(jwt);
		}
		
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
	}

	/*@PostMapping(path = "registro", consumes= {MediaType.APPLICATION_JSON})
	public SignupResult registro(@RequestBody String NIF_hash,
								@RequestBody String password_hash){

	}*/


}
