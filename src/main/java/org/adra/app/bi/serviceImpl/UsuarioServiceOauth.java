package org.adra.app.bi.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.adra.app.bi.entity.Usuario;
import org.adra.app.bi.repository.UsuarioRepositoryOauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceOauth implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositoryOauth usuarioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository.findByDni(dni);
		System.out.println("Hola: "+dni);
		List<GrantedAuthority> authorities = usuario.getUsuario_rol()
				.stream()
				.map(role ->new SimpleGrantedAuthority(role.getRol().getNo_rol()))
				.collect(Collectors.toList());
		return new User(usuario.getDni(), usuario.getDe_contrasenia(),authorities);
	}
}
