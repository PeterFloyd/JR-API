package com.cadastro.jrapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cadastro.jrapi.models.Login;
import com.cadastro.jrapi.repository.LoginRepository;

@Component
public class LoginService implements UserDetailsService{
	
	private final LoginRepository loginRepository;
	
	@Autowired
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		Login login = Optional.ofNullable(loginRepository.findByUsuario(usuario))
				.orElseThrow(()->new UsernameNotFoundException("Usuario não encontrado."));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROlE_ADMIN");
		
		return new org.springframework.security.core.userdetails.User(login.getUsuario(), login.getSenha(), authorityListAdmin);
	}
}
