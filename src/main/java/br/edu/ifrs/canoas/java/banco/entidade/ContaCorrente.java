package br.edu.ifrs.canoas.java.banco.entidade;

public class ContaCorrente extends Conta implements Tributavel,
		Comparable<ContaCorrente> {

	@Override
	public void deposita(double quantidade) {
		super.deposita(quantidade - 0.1);
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
	
	@Override
	public int compareTo(ContaCorrente outra) {
		return (int) (this.getSaldo() - outra.getSaldo());
	}

}
