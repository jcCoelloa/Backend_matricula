package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.document.Curso;
import com.matricula.repo.ICursoRepo;
import com.matricula.repo.IRepoGenerica;
import com.matricula.service.ICursoService;

@Service
public class CursoServiceImpl extends CRUDImpl<Curso, String> implements ICursoService{
	
	@Autowired
	private ICursoRepo repo;
	
	@Override
	protected IRepoGenerica<Curso, String> getRepo(){
		return repo;
	}
}
