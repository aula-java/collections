package br.edu.ifrs.canoas.java.banco.controle;

import br.edu.ifrs.canoas.java.banco.entidade.Conta;
import br.edu.ifrs.canoas.java.banco.entidade.Transacao;

public class GerenciadorDeTransacoes {

	public static boolean deposita(Conta conta, double valor) {
		if (conta == null || valor < 0)
			return false;
		
		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setDia("hoje");
		transacao.setHora("agora");
		transacao.setTipo("deposito");
		transacao.setValor(valor);
		
		conta.getTransacoes().add(transacao);
		conta.deposita(valor);
		
		return true;
	}

	public static boolean saque(Conta conta, double valor) {
		if (conta == null || valor < 0)
			return false;
		
		if (conta.saca(valor)) {
			Transacao transacao = new Transacao();
			transacao.setConta(conta);
			transacao.setDia("hoje");
			transacao.setHora("agora");
			transacao.setTipo("saque");
			transacao.setValor(valor);
			
			conta.getTransacoes().add(transacao);
			return true;
		}
		
		return false;
	}

}
