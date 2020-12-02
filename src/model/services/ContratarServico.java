package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ContratarServico {

	private ServicoDePagamentoOnline servicoDePagamentoOnline;

	public ContratarServico(ServicoDePagamentoOnline servicoDePagamentoOnline) {
		this.servicoDePagamentoOnline =servicoDePagamentoOnline;
	}

	public void processContract(Contrato contrato, int mes) {
		double cotaBasica = contrato.getValorTotal() / mes;
        for (int i = 1; i <= mes; i++) {
            Date data = addMonths(contrato.getData(), i);
            double updatedCota = cotaBasica + servicoDePagamentoOnline.interesse(cotaBasica, i);
            double fullCota =  updatedCota + servicoDePagamentoOnline.taxaDePagamento(updatedCota);
            contrato.addPrestacao(new Prestacao(data, fullCota));
        }
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
