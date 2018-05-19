package com.ia.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.web.models.Evaluations;
import com.ia.web.services.EvaluationService;

@Controller
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationsService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody void save(@RequestBody Evaluations evaluation) {

		
		evaluationsService.save(evaluation);
		System.out.println("Imprimindo . . .");
		print();
		
	}
	
	public void print() {
		List<Evaluations> findAll = evaluationsService.findAll();
		
		for (Evaluations evaluations : findAll) {
			System.out.println(evaluations.getId());
			System.out.println(evaluations.getValue());
		}
	}
	
}
