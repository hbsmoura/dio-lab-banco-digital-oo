package com.hbsmoura.bancodigital.entidades;

import java.time.format.DateTimeFormatter;

public class Deposito extends Transacao {

	public Deposito(double valorDepositado, double saldoRemanescente) {
		super(valorDepositado, saldoRemanescente);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Depósito no valor de %.2f realizado em %s. Saldo Remanescente: %.2f",
				super.getValor(),
				super.getMoment().format(DateTimeFormatter.ISO_DATE_TIME),
				super.getSaldoRemanescente());		
	}
	
}
