package com.matricula.repo;

import org.springframework.data.mongodb.repository.Query;

import com.matricula.document.Estudiante;

import reactor.core.publisher.Flux;

public interface IEstudianteRepo extends IRepoGenerica<Estudiante, String>{
	@Query(sort = "{ edad : -1 }")
	Flux<Estudiante> OrderByEdad();
	
}
