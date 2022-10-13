package com.hbsmoura.bancodigital.entidades;

import java.time.format.DateTimeFormatter;

public class TransferenciaEnviada extends Transacao {
	
	private Conta contaDestino;
	
	public TransferenciaEnviada(double valorTransferido, double saldoRemanescente, Conta contaDestino) {
		super(valorTransferido, saldoRemanescente);
		this.contaDestino = contaDestino;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Tranferência enviada no valor de %.2f realizado em %s para %s. Saldo Remanescente: %.2f",
				super.getValor(),
				super.getMoment().format(DateTimeFormatter.ISO_DATE_TIME),
				contaDestino.cliente.getNome(),
				super.getSaldoRemanescente());		
	}
}
