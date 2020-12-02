package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date datadeVencimento;
	private Double montante;

	public Prestacao() {
	}

	public Prestacao(Date datadeVencimento, Double montante) {
		this.datadeVencimento = datadeVencimento;
		this.montante = montante;
	}

	public Date getDatadeVencimento() {
		return datadeVencimento;
	}

	public void setDatadeVencimento(Date datadeVencimento) {
		this.datadeVencimento = datadeVencimento;
	}

	public Double getMontante() {
		return montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}
	@Override
	public String toString() {
		return sdf.format(datadeVencimento) + " - " + String.format("%.2f", montante);
 	}
}
