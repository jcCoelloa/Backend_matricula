package com.matricula.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepoGenerica<T,ID> extends ReactiveMongoRepository<T, ID> {

}
