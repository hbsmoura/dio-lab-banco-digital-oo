package com.hbsmoura.bancodigital.entidades;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String toString() {
		return "Conta Poupança: " + super.numero + ", Agência: " + super.agencia + ", Titular: " + super.cliente.getNome();
	}

}
