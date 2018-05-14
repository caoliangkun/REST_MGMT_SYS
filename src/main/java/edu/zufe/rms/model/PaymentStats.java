package edu.zufe.rms.model;

public class PaymentStats {
	private double jan;
	private double feb;
	private double mar;
	private double apr;
	private double may;
	private double jun;
	private double jul;
	private double aug;
	private double sep;
	private double oct;
	private double nov;
	private double dec;
	
	public PaymentStats() {
		jan = 0.0;
		feb = 0.0;
		mar = 0.0;
		apr = 0.0;
		may = 0.0;
		jun = 0.0;
		jul = 0.0;
		aug = 0.0;
		sep = 0.0;
		oct = 0.0;
		nov = 0.0;
		dec = 0.0;
	}

	public PaymentStats(double jan, double feb, double mar, double apr, double may, double jun, double jul, double aug, double sep, double oct,
			double nov, double dec) {
		super();
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
		this.may = may;
		this.jun = jun;
		this.jul = jul;
		this.aug = aug;
		this.sep = sep;
		this.oct = oct;
		this.nov = nov;
		this.dec = dec;
	}

	public double getJan() {
		return jan;
	}

	public void setJan(double jan) {
		this.jan = jan;
	}

	public double getFeb() {
		return feb;
	}

	public void setFeb(double feb) {
		this.feb = feb;
	}

	public double getMar() {
		return mar;
	}

	public void setMar(double mar) {
		this.mar = mar;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public double getMay() {
		return may;
	}

	public void setMay(double may) {
		this.may = may;
	}

	public double getJun() {
		return jun;
	}

	public void setJun(double jun) {
		this.jun = jun;
	}

	public double getJul() {
		return jul;
	}

	public void setJul(double jul) {
		this.jul = jul;
	}

	public double getAug() {
		return aug;
	}

	public void setAug(double aug) {
		this.aug = aug;
	}

	public double getSep() {
		return sep;
	}

	public void setSep(double sep) {
		this.sep = sep;
	}

	public double getOct() {
		return oct;
	}

	public void setOct(double oct) {
		this.oct = oct;
	}

	public double getNov() {
		return nov;
	}

	public void setNov(double nov) {
		this.nov = nov;
	}

	public double getDec() {
		return dec;
	}

	public void setDec(double dec) {
		this.dec = dec;
	} 
	
	
}
