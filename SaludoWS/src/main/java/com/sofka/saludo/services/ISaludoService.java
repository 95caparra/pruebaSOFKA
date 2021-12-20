package com.sofka.saludo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sofka.saludo.entity.Usuario;

public interface ISaludoService {
	
	public List<Usuario> findAllUsuarios();
	
	public Usuario findByNombre(String nombre);

}
