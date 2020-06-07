package com.app.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.config.SecurirySetting;
import com.app.entity.AppUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	
 
	private AuthenticationManager  authenticationManager;
 
	public jwtAuthentificationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {

			AppUser appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
		}catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

		User user = (User) authResult.getPrincipal();
		List<String> roles = new ArrayList<>(); 
		
		authResult.getAuthorities().forEach(a->{
			roles.add(a.getAuthority());
		});
		
		String jwt = JWT.create()
				
				// prÃ©paration de Tocken
				.withIssuer(request.getRequestURI()) // probriÃ©taire de JWT
				.withSubject(user.getUsername()) // nom d'utilisateur
				.withArrayClaim("roles", roles.toArray(new String[roles.size()])) // les roles
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurirySetting.EXPIRATION)) // date d'expiration de json web tocken
				.sign(Algorithm.HMAC256(SecurirySetting.SECRET)); // sucret
		
		// gÃ©nere le Tocken
		response.addHeader(SecurirySetting.JWT_HEADER_NAME,jwt);
		
		System.out.println(jwt);
 
	}

}
