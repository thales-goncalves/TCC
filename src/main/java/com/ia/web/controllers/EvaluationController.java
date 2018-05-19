package com.ia.web.controllers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.web.models.Evaluations;
import com.ia.web.models.Workfields;
import com.ia.web.services.EvaluationService;

@Controller
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationsService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody void save(@RequestBody Evaluations evaluation) {

		
		//evaluationsService.save(evaluation);
		
		JSONArray jsonArray = new JSONArray(evaluation.getValue());
		JSONObject object = new JSONObject();
		
		Integer imagem; 
		Integer grade; 
		
		Integer Exact = 0;
		Integer Biological = 0;
		Integer Human = 0;
		
		List<Workfields> fields = evaluationsService.findAllWorksfields();
	
		
		for (int index=0 ; index < jsonArray.length(); index++) {
			
			object = jsonArray.getJSONObject(index);
			
			imagem = object.getInt("image");
			grade = object.getInt("record");
		
			if(fields.get(imagem-1).getArea().equals("Exact") && grade == 1) {
				Exact+=1;
			}
			else if(fields.get(imagem-1).getArea().equals("Biological") && grade == 1) {
				Biological+=1;
			}
			else if(fields.get(imagem-1).getArea().equals("Human") && grade == 1) {
				Human+=1;
			}
			
		}
		
		
		System.out.println("Imprimindo . . .");
		System.out.println("Exact " + Exact);
		System.out.println("Biological " + Biological);
		System.out.println("Human " + Human);
		
	}
	
	public void print() {
		
		List<Evaluations> findAll = evaluationsService.findAll();
		
		for (Evaluations evaluations : findAll) {
			System.out.println(evaluations.getId());
			System.out.println(evaluations.getValue());
		}
		
		
		
	}
	
}
