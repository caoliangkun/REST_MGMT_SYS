package edu.zufe.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.enums.TableStatus;
import edu.zufe.rms.model.Table;
import edu.zufe.rms.service.TableService;

@Controller
public class TableController {
	@Autowired
	private TableService tableService;

	@GetMapping("/addTable")
	public String addTable(@RequestParam(name = "tableId") String tableId,
			@RequestParam(name = "capacity") String capacity,
			@RequestParam(name = "status") String status) {
		tableService.save(tableId, capacity, status);
		return "admin/add_table";
	}
	
	@GetMapping(path = "/showTablesForAdmin")
	public String showTablesForAdmin(Model model) {
		List<Table> tables = tableService.findAll();
		model.addAttribute("tables", tables);
		return "admin/admin_tables";
	}
	
	@GetMapping(path = "/showTables")
	public String showTables(Model model) {
		List<Table> tables = tableService.findAll();
		model.addAttribute("tables", tables);
		return "tables";
	}
	
	@GetMapping(path = "/deleteTable")
	public String deleteTable(@RequestParam(name = "id") String id) {
		tableService.deleteById(id);
		return "admin/admin_tables";
	}
	
	@GetMapping("/updateTable")
	public String updateTable(Model model) {
		List<Table> tables = tableService.findAll();
		model.addAttribute("tables", tables);
		List<String> statuses = new ArrayList<>();
		for (TableStatus ts : TableStatus.values()) {
			statuses.add(ts.toString());
		}
		
		model.addAttribute("statuses", statuses);
		return "admin/update_table";
	}
	
	@GetMapping("/changeTableStatus")
	public String changeTableStatus(@RequestParam(name= "id") String id, 
			@RequestParam(name = "status") String status) {
		tableService.updateStatus(id, status);
		return "redirect:updateTable";
	}
	
}
