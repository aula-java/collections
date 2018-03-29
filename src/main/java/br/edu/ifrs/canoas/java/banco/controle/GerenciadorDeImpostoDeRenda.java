package br.edu.ifrs.canoas.java.banco.controle;

import br.edu.ifrs.canoas.java.banco.entidade.Tributavel;

public class GerenciadorDeImpostoDeRenda {
	private double total;

	void adiciona(Tributavel t) {
		this.total += t.calculaTributos();
	}

	public double getTotal() {
		return this.total;
	}
}
