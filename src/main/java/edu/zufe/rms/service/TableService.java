package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.enums.TableStatus;
import edu.zufe.rms.model.Table;
import edu.zufe.rms.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepo;

	public Table save(String tableId, String capacity, String status) {
		Table table = new Table(Long.valueOf(tableId), Integer.valueOf(capacity), TableStatus.valueOf(status));
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

	public void deleteById(String id) {
		tableRepo.deleteById(Long.valueOf(id));
	}

	public void updateStatus(String id, String status) {
		Optional<Table> table = tableRepo.findById(Long.valueOf(id));
		if (table.isPresent()) {
			Table t = table.get();
			t.setTableStatus(TableStatus.valueOf(status));
			tableRepo.save(t);
		}
		
	}

	public edu.zufe.rms.model.Table findById(Long tableId) {
		Optional<Table> table = tableRepo.findById(tableId);
		if (table.isPresent()) {
			return table.get();
		}
		return null;
	}
}
