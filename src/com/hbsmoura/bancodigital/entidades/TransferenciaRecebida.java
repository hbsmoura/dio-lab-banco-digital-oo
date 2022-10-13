package com.hbsmoura.bancodigital.entidades;

import java.time.format.DateTimeFormatter;

public class TransferenciaRecebida extends Transacao {
	
	private Conta contaOrigem;
	
	public TransferenciaRecebida(double valorTransferido, double saldoRemanescente, Conta contaOrigem) {
		super(valorTransferido, saldoRemanescente);
		this.contaOrigem = contaOrigem;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Tranferência recebida no valor de %.2f realizado em %s por %s. Saldo Remanescente: %.2f",
				super.getValor(),
				super.getMoment().format(DateTimeFormatter.ISO_DATE_TIME),
				contaOrigem.cliente.getNome(),
				super.getSaldoRemanescente());		
	}

}
