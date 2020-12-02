package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.services.ContratarServico;
import model.services.PayPalServico;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira os dados do contrato ");
		System.out.println("Número: ");
		int numero = sc.nextInt();
		System.out.println("Data (dd/MM/aaaa): ");
		Date data = sdf.parse(sc.next());
		System.out.println("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.println("Insira o número de parcelas: ");
		int n = sc.nextInt();
		System.out.println("Installments: ");
		

		ContratarServico contratarServico = new ContratarServico(new PayPalServico());
		
		contratarServico.processContract(contrato, n);
		
		for (Prestacao x: contrato.getPrestacao()) {
			System.out.println(x);
		}

		sc.close();

	}

}
