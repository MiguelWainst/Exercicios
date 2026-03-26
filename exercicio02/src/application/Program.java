package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.product.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String path = "C:\\temp\\arquivo.csv";
		File pasta = new File("C:\\temp\\out\\");
		pasta.mkdir();
		String pathFinal = "C:\\temp\\out\\summary.csv";
		
		List<String> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] temp = {};
				
				temp = line.split(",");
				Product product = new Product(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]));
				list.add(product.toString());
				
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Erro");
		}
		
		for (String x : list) {
			System.out.println(x.toString());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathFinal))) {
			for (String x : list) {
				bw.write(x.toString() + "\n");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
