package br.edu.ifrs.canoas.java.banco.entidade;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}

	@Override
	public int compareTo(ContaPoupanca outra) {
		return this.getNumero() - outra.getNumero();
	}

}
