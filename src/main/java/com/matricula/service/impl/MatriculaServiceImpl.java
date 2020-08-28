package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.document.Matricula;
import com.matricula.repo.IMatriculaRepo;
import com.matricula.repo.IRepoGenerica;
import com.matricula.service.IMatriculaService;

@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula, String> implements IMatriculaService {
	
	@Autowired
	private IMatriculaRepo repo;
	
	@Override
	protected IRepoGenerica<Matricula, String> getRepo(){
		return repo;
	}
}
