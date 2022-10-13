package com.hbsmoura.bancodigital.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hbsmoura.bancodigital.exceptions.SaldoInsuficienteException;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	List<Transacao> transacoes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public void sacar(double valor) {
		if(this.saldo < valor) throw new SaldoInsuficienteException();
		this.saldo -= valor;
		transacoes.add(new Saque(valor, this.saldo));
	}

	public void depositar(double valor) {
		this.saldo += valor;
		transacoes.add(new Deposito(valor, this.saldo));
	}

	public void enviarTransferencia(double valor, Conta contaDestino) {
		if(this.saldo < valor) throw new SaldoInsuficienteException();
		this.saldo -= valor;
		transacoes.add(new TransferenciaEnviada(valor, this.saldo, contaDestino));
		
		contaDestino.receberTransferencia(valor, this);
	}

	public void receberTransferencia(double valor, Conta contaOrigem) {
		this.saldo += valor;
		transacoes.add(new TransferenciaRecebida(valor, this.saldo, contaOrigem));
		
	}
	
	public double obterSaldo() {
		return this.saldo;
	}

	public List<Transacao> obterTransacoes() {
		return transacoes;
	}
	
	public List<Transacao> obterExtrato(LocalDateTime inicio, LocalDateTime fim) {
		LocalDateTime inicioExtrato = inicio == null ? this.transacoes.get(0).getMoment() : inicio;
		LocalDateTime fimExtrato = fim == null ? this.transacoes.get(this.transacoes.size()-1).getMoment() : fim;
		
		List<Transacao> transacoesExtrato = new ArrayList<>();
		transacoes.forEach((transacao) -> {
			if(transacao.getMoment().isAfter(inicioExtrato.minusMinutes(1L)) && transacao.getMoment().isBefore(fimExtrato.plusMinutes(1L))) {
				transacoesExtrato.add(transacao);
			}
		});
		
		return transacoesExtrato;
	}
}
