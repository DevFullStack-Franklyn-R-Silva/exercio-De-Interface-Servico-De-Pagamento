package model.services;

public class PayPalServico implements ServicoDePagamentoOnline{
	private static final double TAXA_PORCENTAGEM= 0.02;
	private static final double JUROS_MENSAIS = 0.01;

	@Override
	public double taxaDePagamento(double montante) {
		return montante * TAXA_PORCENTAGEM;
	}

	@Override
	public double interesse(double montante, int mes) {
		return montante * JUROS_MENSAIS * mes;
	}
}
