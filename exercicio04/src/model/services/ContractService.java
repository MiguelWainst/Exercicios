package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		Double valuePerContract = contract.getTotalValue() / months;
		
		for (int i=1; i<=months; i++) {
			LocalDate mesDoContrato = contract.getDate().plusMonths((i)); // Pega a data inicial e adiciona "i" pra apontar o mes
			
			double interest = onlinePaymentService.interest(valuePerContract, (i)); // Adiciona o juros simples
			double fee = onlinePaymentService.paymentFee(interest + valuePerContract); // Passa o valor já com o juros
			double finalValuePerContract = valuePerContract + interest + fee; // Guarda o valor total
			
			contract.getInstallment().add(new Installment(mesDoContrato, finalValuePerContract)); // Passa pra lista Installment
		}
		
	}
}
