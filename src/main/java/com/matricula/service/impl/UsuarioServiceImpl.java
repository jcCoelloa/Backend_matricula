package com.matricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.document.Usuario;
import com.matricula.repo.IRepoGenerica;
import com.matricula.repo.IRolRepo;
import com.matricula.repo.IUsuarioRepo;
import com.matricula.seguridad.User;
import com.matricula.service.IUsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//Clase ocho
@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, String> implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepo usurepo;
	
	@Autowired 
	private IRolRepo rolrepo;
	
	@Override
	protected IRepoGenerica<Usuario, String> getRepo(){
		return usurepo;
	}
	
	@Override
	public Mono<User> buscarPorUsuario(String usuario) {
		Mono<Usuario> monoUsuario = usurepo.findOneByUsuario(usuario);
		
		List<String> roles = new ArrayList<String>();
		
		return monoUsuario.flatMap(u -> {
			return Flux.fromIterable(u.getRoles())
					.flatMap(rol -> {
						return rolrepo.findById(rol.getId())
								.map(r -> {
									roles.add(r.getNombre());
									return r;
								});
					}).collectList().flatMap(list -> {
						u.setRoles(list);
						return Mono.just(u);
					});
		})	
		.flatMap(u -> {			
			return Mono.just(new User(u.getUsuario(), u.getClave(), u.getEstado(), roles));
		});
	}
	
}
