package com.hbsmoura.bancodigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hbsmoura.bancodigital.entidades.Banco;
import com.hbsmoura.bancodigital.entidades.Cliente;
import com.hbsmoura.bancodigital.entidades.Conta;
import com.hbsmoura.bancodigital.entidades.ContaCorrente;
import com.hbsmoura.bancodigital.entidades.ContaPoupanca;
import com.hbsmoura.bancodigital.entidades.Transacao;

public class App {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta contaCorrrente = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		
		Banco banco = new Banco("Banco Fictício");
		
		banco.adicionarConta(contaCorrrente);
		banco.adicionarConta(poupanca);

		contaCorrrente.depositar(100);
		contaCorrrente.depositar(200);
		contaCorrrente.enviarTransferencia(100, poupanca);
		contaCorrrente.sacar(50);

		List<Transacao> extratoContaCorrente =
				contaCorrrente.obterExtrato(contaCorrrente.obterTransacoes().get(0).getMoment(),
						contaCorrrente.obterTransacoes().get(contaCorrrente.obterTransacoes().size()-1).getMoment());		
				
		List<Transacao> extratoPoupanca =
				poupanca.obterExtrato(poupanca.obterTransacoes().get(0).getMoment(),
						poupanca.obterTransacoes().get(poupanca.obterTransacoes().size()-1).getMoment());
		

		System.out.println("***Informações sobre o banco e suas contas***");
		System.out.println(banco);
		
		System.out.println("\n***Extrato da Conta Corrente em " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "***");
		extratoContaCorrente.forEach(System.out::println);		
		
		System.out.println("\n***Saldo da Conta Corrente em " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "***");
		System.out.println(contaCorrrente.obterSaldo());
		
		System.out.println("\n***Extrato da Poupanca em " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "***");
		extratoPoupanca.forEach(System.out::println);
		
		System.out.println("\n***Saldo da Poupança em " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "***");
		System.out.println(poupanca.obterSaldo());
	}

}
