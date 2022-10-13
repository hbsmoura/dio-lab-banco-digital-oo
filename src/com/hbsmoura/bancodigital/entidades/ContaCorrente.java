package com.hbsmoura.bancodigital.entidades;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String toString() {
		return "Conta Corrente: " + super.numero + ", Agência: " + super.agencia + ", Titular: " + super.cliente.getNome();
	}

}
