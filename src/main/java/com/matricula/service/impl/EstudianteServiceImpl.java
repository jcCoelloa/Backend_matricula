package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.document.Estudiante;
import com.matricula.repo.IEstudianteRepo;
import com.matricula.repo.IRepoGenerica;
import com.matricula.service.IEstudianteService;

import reactor.core.publisher.Flux;

@Service
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, String> implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepo repo;
	
	@Override
	protected IRepoGenerica<Estudiante, String> getRepo(){
		return repo;
		
	}

	@Override
	public Flux<Estudiante> OrderByEdad() {
		return repo.OrderByEdad();
	}
}
