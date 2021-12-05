package org.adra.app.bi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.adra.app.bi.entity.Rol;
import org.adra.app.bi.entity.Socio;
import org.adra.app.bi.entity.Usuario;
import org.adra.app.bi.repository.RolRepository;
import org.adra.app.bi.repository.SocioRepository;
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
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByDni(dni);
        List<Rol> roles= rolRepository.listarRoles(usuario.getId());
        List<Object> socios = socioRepository.listarSocios(usuario.getId());
		
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      
		if (roles.isEmpty()) {
			for (int i=0;i<socios.size(); i++) {
				System.out.println();
				authorities.add(new SimpleGrantedAuthority("Socio"));
			}
		} else {
			for (int i=0;i<roles.size(); i++) {
				System.out.println();
				authorities.add(new SimpleGrantedAuthority(roles.get(i).getNo_rol()));
				
			}
		}
        
		return new User(usuario.getDni(), usuario.getDe_contrasenia(), true, true ,true, true, authorities);
	}
}
