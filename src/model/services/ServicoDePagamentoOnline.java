package model.services;

public interface ServicoDePagamentoOnline {
	
		double taxaDePagamento(double montante);
		double interesse(double montante, int mes);
		
}
