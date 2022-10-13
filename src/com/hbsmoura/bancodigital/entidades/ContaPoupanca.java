package com.hbsmoura.bancodigital.entidades;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String toString() {
		return "Conta Poupan�a: " + super.numero + ", Ag�ncia: " + super.agencia + ", Titular: " + super.cliente.getNome();
	}

}
