package model.service;

public class BrazilTaxService implements TaxService{
	
	public Double tax(double amount) {
		return amount <= 100 ? amount * 0.2 : amount * 0.15;
	}
}
