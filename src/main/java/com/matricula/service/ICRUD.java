package com.matricula.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T,ID> {
	
	Mono<T> registrar (T obj);
	Flux<T> listar();
	Mono<T> modificar (T obj);
	Mono<Void> eliminar(ID id);
	Mono<T> listarPorId(ID id);
	
	
}
