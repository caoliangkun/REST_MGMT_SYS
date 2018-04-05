package edu.zufe.rms.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ledger {
	@Id
	@GeneratedValue
	private int id;
	private LedgerType ledgerType;
	private double amount;
	private Object from;
	private Object to;
	private Date occureTime;
}
