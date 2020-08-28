package com.matricula.repo;

import com.matricula.document.Usuario;

import reactor.core.publisher.Mono;

public interface IUsuarioRepo extends IRepoGenerica<Usuario, String> {
	
	Mono<Usuario> findOneByUsuario(String usuario);

}
