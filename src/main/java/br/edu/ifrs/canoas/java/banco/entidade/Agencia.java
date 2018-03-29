package br.edu.ifrs.canoas.java.banco.entidade;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private List<Conta> contas;
	private int numero;
	
	public Agencia() {
		contas = new ArrayList<Conta>();
	}
	
	public void adicionaConta(Conta conta){
		contas.add(conta);
	}
	
	public double getSaldoTotal(){
		double total = 0;
		
		for (Conta conta : contas) 
			total+=conta.getSaldo();
		
		return total;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
