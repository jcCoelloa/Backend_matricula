package com.matricula.service;

import com.matricula.document.Estudiante;

import reactor.core.publisher.Flux;

public interface IEstudianteService extends ICRUD<Estudiante, String> {
		
	Flux<Estudiante> OrderByEdad();
}
