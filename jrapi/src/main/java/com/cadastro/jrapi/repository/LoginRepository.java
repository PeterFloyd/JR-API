package com.cadastro.jrapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cadastro.jrapi.models.Login;

public interface LoginRepository extends PagingAndSortingRepository<Login, String>{

	Login findByUsuario(String usuario);
	
}
