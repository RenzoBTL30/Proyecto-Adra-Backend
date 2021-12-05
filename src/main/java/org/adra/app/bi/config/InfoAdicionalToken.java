package org.adra.app.bi.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.adra.app.bi.entity.Persona;
import org.adra.app.bi.entity.Usuario;
import org.adra.app.bi.repository.PersonaRepository;
import org.adra.app.bi.repository.UsuarioRepository;
import org.adra.app.bi.repository.UsuarioRepositoryOauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private UsuarioRepositoryOauth usuarioRepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioRepository.findByDni(authentication.getName());
		System.out.println(authentication.getName());
		Map<String, Object> info = new HashMap<>();		
		info.put("idusuario", usuario.getId());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);		
		return accessToken;
	}

}
