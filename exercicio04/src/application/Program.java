package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;

public class Program {
	
	public static void main(String args[]) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter with contract data:");
		System.out.print("Number: ");
		Integer contractNumber = sc.nextInt();
		System.out.print("Date (DD/MM/YYYY): ");
		sc.nextLine();
		LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Contract value: ");
		Double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractDate, contractValue);
		
		System.out.print("Enter the number of installments: ");
		Integer numberOfInstallments = sc.nextInt();
		
		ContractService servicePaypal = new ContractService();
		servicePaypal.processContract(contract, numberOfInstallments);
		
		System.out.println("Installments:");
		for (Installment x : contract.getInstallment()) {
			System.out.print(x.getDueDate().format(fmt) + " - ");
			System.out.println(String.format("%.2f", x.getAmount()));
		}
		
		
		
		sc.close();
	}
}
