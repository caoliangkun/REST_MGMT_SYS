package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.ResttMgmtSysApplication;
import edu.zufe.rms.service.TableService;

@Controller
public class TableController {
	@Autowired
	private TableService tableService;

	@GetMapping("/addTable")
	public String addTable(@RequestParam(name = "capacity") String capacity,
			@RequestParam(name = "status") String status) {
		ResttMgmtSysApplication.log.info("add table");
		tableService.save(capacity, status);
		return "admin/add_table";
	}
	
	
}
