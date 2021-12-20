package com.sofka.saludo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sofka.saludo.entity.Usuario;

public interface IUsuarioService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public Usuario findByUsername(String username);
}
