package com.ia.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ia.web.models.Evaluations;
import com.ia.web.models.Workfields;

@Repository
@Transactional
public class EvaluationRepository {

	@PersistenceContext
	private EntityManager manager;

	public void save(Evaluations evaluation) {
		manager.merge(evaluation);
	}
	
	public List<Evaluations> findAll(){
		return manager.createQuery("select e from Evaluations e", Evaluations.class).getResultList();
	}
	
	public List<Workfields> findAllWorksfields(){
		return manager.createQuery("select w from Workfields w", Workfields.class).getResultList();
	}

}
