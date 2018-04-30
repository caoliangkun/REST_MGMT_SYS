package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.enums.TableStatus;
import edu.zufe.rms.model.Table;
import edu.zufe.rms.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepo;

	public Table save(String capacity, String status) {
		Table table = new Table(Integer.valueOf(capacity), TableStatus.valueOf(status));
		return tableRepo.save(table);
	}

	public Table save() {
		return tableRepo.save(new Table());
		
	}

	public List<Table> findAll() {
		List<Table> tables = new ArrayList<>();
		for (Table t : tableRepo.findAll()) {
			tables.add(t);
		}
		return tables;
	}
}
