package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.service.SelectionService;

@Controller
public class SelectionController {
	@Autowired
	SelectionService selectionService;
	
	@GetMapping(path= "/select")
	public String select(@RequestParam(name = "id") Long id) {
		selectionService.saveSelection(id);
		return null;
	}
}
