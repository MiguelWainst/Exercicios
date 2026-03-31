package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.print("Car model: ");
		String car = sc.nextLine();
		System.out.print("Pickup date: ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Return date: ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(start, finish, new Vehicle(car));
		
		System.out.print("Value per hour: ");
		Double valuePerHour = sc.nextDouble();
		System.out.print("Value per day: ");
		Double valuePerDay = sc.nextDouble();
		
		RentalService rentalSerivce = new RentalService(valuePerHour, valuePerDay, new BrazilTaxService());
		
		rentalSerivce.processInvoice(cr);	
		
		System.out.println("FATURA:");
		System.out.print("Basic payment: " + cr.getInvoice().getBasicPayment());
		System.out.print("Tax: " + cr.getInvoice().getTax());
		System.out.println("Total payment: " + cr.getInvoice().getTotalPayment());
		
		
		sc.close();		
	}
}
