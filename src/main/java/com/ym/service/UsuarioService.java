package com.ym.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.ym.entity.Usuario;
import com.ym.repository.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService implements UserDetailsService {
	
	
	@Autowired
	@Qualifier("UsuarioRepository")
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = repo.findByNombre(username);
		return new User(user.getNombre(), user.getPass(), user.isStatus(), user.isStatus(), user.isStatus(), user.isStatus(), buildgrante(user.getRol()));
	}
	
	public List<GrantedAuthority> buildgrante(byte rol){
		
		String[] roles = {"LECTOR","USUARIO","ADMIN"};
		
		List<GrantedAuthority> auth = new ArrayList<>();
		
		for (int i = 0; i< rol; i++) {
			
			auth.add(new SimpleGrantedAuthority(roles[i])); 
		}
		
		return auth;
	}

}
