package com.hbsmoura.bancodigital.entidades;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	@Override
	public String toString() {
		String descricao = "Nome: " + this.nome;
		for(Conta conta : contas) {
			descricao = descricao.concat("\n" + conta.toString());
		}
		return descricao;
	}

}
