package com.sofka.saludo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.saludo.dao.IRolDAO;
import com.sofka.saludo.entity.Role;
import com.sofka.saludo.services.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDAO rolDAO;
	
	@Override
	public Role rolById(Long id) {
		return rolDAO.findById(id).orElse(null);
	}

}
