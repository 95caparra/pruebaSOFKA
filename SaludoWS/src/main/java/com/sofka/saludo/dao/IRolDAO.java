package com.sofka.saludo.dao;

import org.springframework.data.repository.CrudRepository;

import com.sofka.saludo.entity.Role;


public interface IRolDAO  extends CrudRepository<Role, Long>{

}
