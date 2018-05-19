package com.ia.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.web.models.Evaluations;
import com.ia.web.repositories.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;

	public void save(Evaluations evaluation) {
		evaluationRepository.save(evaluation);
	}
	
	public List<Evaluations> findAll(){
		return evaluationRepository.findAll();
	}
	
}
