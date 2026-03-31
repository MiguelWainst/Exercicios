package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	public void processContract(Contract contract, Integer months) {
		
		Double valuePerContract = contract.getTotalValue() / months;
		
		PaypalService paypalService = new PaypalService();
		
		for (int i=0; i<months; i++) {
			Double finalValuePerContract = valuePerContract 
					+ paypalService.interest(valuePerContract, (i+1)) 
					+ paypalService.paymentFee(paypalService.interest(valuePerContract, (i+1)));
			
			contract.getInstallment().add(new Installment(contract.getDate().plusMonths((i+1)), finalValuePerContract));
		}
		
	}
}
