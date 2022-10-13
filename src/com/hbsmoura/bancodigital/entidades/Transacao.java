package com.hbsmoura.bancodigital.entidades;

import java.time.LocalDateTime;

public abstract class Transacao {
	
	private double valor;
	private double saldoRemanescente;
	private LocalDateTime moment;
	
	public Transacao(double valor, double saldoRemanescente) {
		this.valor = valor;
		this.saldoRemanescente = saldoRemanescente;
		this.moment = LocalDateTime.now();
	}

	public double getValor() {
		return valor;
	}

	public double getSaldoRemanescente() {
		return saldoRemanescente;
	}

	public LocalDateTime getMoment() {
		return moment;
	}	
	
}
