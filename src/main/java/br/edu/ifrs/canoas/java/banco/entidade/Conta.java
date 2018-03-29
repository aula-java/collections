package br.edu.ifrs.canoas.java.banco.entidade;

public abstract class Conta {
	
	private int numero;
	protected double saldo;
	private double limite;
	private Cliente titular;

	public boolean saca(double valor) {
		if (this.saldo < valor) {
			return false;
		} else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}

	public void deposita(double quantidade) {
		this.saldo += quantidade;
	}

	public boolean transfere(Conta destino, double valor) {
		boolean retirou = this.saca(valor);
		if (retirou == false) {
			//nao foi possivel sacar
			return false;
		} else {
			destino.deposita(valor);
			return true;
		}
	}
	
	public void atualiza(double taxaSelic) {
        this.saldo += this.saldo * taxaSelic;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	

}
