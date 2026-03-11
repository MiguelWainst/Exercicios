package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.PF;
import entities.PJ;
import entities.Pessoa;

public class Program 
{
	public static void main(String args[] )
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> pessoa = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=0; i<n; i++)
		{
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			
			if(resp == 'i')
			{
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Health expendirutes: ");
				Double healthExpenditures = sc.nextDouble();
				pessoa.add(new PF(name, rendaAnual, healthExpenditures));
			}
			else if(resp == 'c')
			{
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Number of employees: ");
				Integer employeeNumber = sc.nextInt();
				pessoa.add(new PJ(name, rendaAnual, employeeNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		Double sum = 0.0;
		for(Pessoa pss : pessoa)
		{
			System.out.println(pss.getName() + ": $ " + String.format("%.2f", pss.tax()));
			sum += pss.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + sum);
		
		sc.close();
	}
}
























