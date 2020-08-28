package com.matricula.service.impl;

import com.matricula.repo.IRepoGenerica;
import com.matricula.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {
	
	protected abstract IRepoGenerica<T, ID> getRepo();
	
	@Override
	public Mono<T> registrar(T obj){
		return getRepo().save(obj);
	}
	
	@Override
	public Flux<T> listar(){
		return getRepo().findAll();
	}
	
	@Override
	public Mono<T> modificar(T obj){
		return getRepo().save(obj);
	}
	
	@Override
	public Mono<Void> eliminar(ID id){
		return getRepo().deleteById(id);
	}
	
	@Override
	public Mono<T> listarPorId(ID id){
		return getRepo().findById(id);
	}

}
