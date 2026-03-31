package model.service;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		double durationInMinutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		
		double basicPayment;
		if (durationInMinutes / 60 <= 12) {
			basicPayment = pricePerHour * Math.ceil((durationInMinutes / 60));
		}
		else {
			basicPayment = pricePerDay * Math.ceil((durationInMinutes / 60) / 24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));		
	}
	
}
