package br.edu.ifrs.canoas.java.banco.entidade;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String sobrenome;
	private String cpfCnpj;
	private List<Conta> contas;
	
	public Cliente() {
		contas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpf) {
		this.cpfCnpj = cpf;
	}
	
	
	public boolean adicionaConta(Conta cc) {
		if (cc == null || contas.contains(cc))
			return false;
		
		cc.setCliente(this);
		return contas.add(cc);
	}
	
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public double getTotalContaCorrente() {
		double total = 0.0;
		
		if (contas == null) 
			return total;
		
		for (Conta conta : contas) {
			if (conta instanceof ContaCorrente)
				total += conta.getSaldo();
		}
		return total;
	}
	
	public double getTotalPoupanca() {
		double total = 0.0;
		
		if (contas == null) 
			return total;
		
		for (Conta conta : contas) {
			if (conta instanceof ContaPoupanca)
				total += conta.getSaldo();
		}
		return total;
	}
	
	
	
}
