package com.hbsmoura.bancodigital.entidades;

import java.time.format.DateTimeFormatter;

public class Saque extends Transacao {
	
	public Saque(double valorSacado, double saldoRemanescente) {
		super(valorSacado, saldoRemanescente);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Saque no valor de %.2f realizado em %s. Saldo Remanescente: %.2f",
				super.getValor(),
				super.getMoment().format(DateTimeFormatter.ISO_DATE_TIME),
				super.getSaldoRemanescente());		
	}
	
}
