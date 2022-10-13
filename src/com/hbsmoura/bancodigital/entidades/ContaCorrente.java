package com.hbsmoura.bancodigital.entidades;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String toString() {
		return "Conta Corrente: " + super.numero + ", Ag�ncia: " + super.agencia + ", Titular: " + super.cliente.getNome();
	}

}
