package com.sofka.saludo.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofka.saludo.dao.IUsuarioDAO;
import com.sofka.saludo.entity.Usuario;
import com.sofka.saludo.services.ISaludoService;

@Service
public class SaludoServiceImpl implements ISaludoService {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> findAllUsuarios() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Usuario findByNombre(String nombre) {
		return usuarioDAO.findByNombre(nombre);
	}

}
