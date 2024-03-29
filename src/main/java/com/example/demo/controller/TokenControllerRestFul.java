package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.UsuarioTo;

@RestController
@RequestMapping(path = "/autorizaciones/jwt")
@CrossOrigin
public class TokenControllerRestFul {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/obtener")
	public String obtenerToken(@RequestBody UsuarioTo usuario) {
		this.authenticated(usuario.getNombre(), usuario.getPassword());
		return this.jwtUtils.generateJwtToken(usuario.getNombre(), usuario.getSemilla(), usuario.getTiempo());
	}

	private void authenticated(String usuario, String password) {
		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
}