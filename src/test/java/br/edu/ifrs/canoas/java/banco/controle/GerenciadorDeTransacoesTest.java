package br.edu.ifrs.canoas.java.banco.controle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.Cliente;
import br.edu.ifrs.canoas.java.banco.entidade.Conta;
import br.edu.ifrs.canoas.java.banco.entidade.ContaCorrente;
import br.edu.ifrs.canoas.java.banco.entidade.ContaPoupanca;
import br.edu.ifrs.canoas.java.banco.entidade.Transacao;

public class GerenciadorDeTransacoesTest {

	@Test
	public void testaDeposito() {
		assertFalse("N�o � poss�vel depositar em conta nula", GerenciadorDeTransacoes.deposita(null, 0));
		assertFalse("N�o � poss�vel depositar em conta nula valor negativo", GerenciadorDeTransacoes.deposita(null, -1));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Rodrigo");
		
		Conta cp = new ContaPoupanca();
		cliente.adicionaConta(cp);
		
		assertFalse("N�o � poss�vel depositar valor negativo",GerenciadorDeTransacoes.deposita(cp, -1));
		
		
		assertTrue(GerenciadorDeTransacoes.deposita(cp, 1000));
		//Para cada operacao, o gerenciador cria uma transa��o mantendo registro
		//da conta, cliente, dia, hora,  valor e tipo (deposito ou saque)
		Transacao transacao = cp.getTransacoes().get(0);
		assertEquals("O nome do cliente da conta que fez a transacao � Rodrigo",
				"Rodrigo", transacao.getConta().getCliente().getNome());
		assertEquals("A conta deve ser a mesma criada",cp, transacao.getConta());
		assertNotNull("Deve ter sido registrado o dia",transacao.getDia());
		assertNotNull("Deve ter sido registrado o dia",transacao.getHora());
		assertEquals("Deve ter sido registrado o tipo como dep�sito","deposito", transacao.getTipo());
		assertEquals("Deve ter sido registrado o valor da transa��o",1000, transacao.getValor(),0);
		assertEquals("Deve ter sido atualizado o saldo da conta poupanca",1000, cp.getSaldo(),0);
	
		//Realiza uma nova transa��o
		assertTrue(GerenciadorDeTransacoes.deposita(cp, 500));
		transacao = cp.getTransacoes().get(1);
		assertEquals("O nome do cliente da conta que fez a transacao � Rodrigo",
				"Rodrigo", transacao.getConta().getCliente().getNome());
		assertEquals("A conta deve ser a mesma criada",cp, transacao.getConta());
		assertNotNull("Deve ter sido registrado o dia",transacao.getDia());
		assertNotNull("Deve ter sido registrado o dia",transacao.getHora());
		assertEquals("Deve ter sido registrado o tipo como dep�sito","deposito", transacao.getTipo());
		assertEquals("Deve ter sido registrado o valor da transa��o",500, transacao.getValor(),0);
		assertEquals("Deve ter sido atualizado o saldo da conta poupanca",1500, cp.getSaldo(),0);

		
		
		
		
		Conta cc = new ContaCorrente();
		cliente.adicionaConta(cc);
		assertTrue(GerenciadorDeTransacoes.deposita(cc, 500));
		transacao = cc.getTransacoes().get(0);
		assertEquals("O nome do cliente da conta que fez a transacao � Rodrigo",
				"Rodrigo", transacao.getConta().getCliente().getNome());
		assertEquals("A conta deve ser a mesma criada",cc, transacao.getConta());
		assertNotNull("Deve ter sido registrado o dia",transacao.getDia());
		assertNotNull("Deve ter sido registrado o dia",transacao.getHora());
		assertEquals("Deve ter sido registrado o tipo da transa��o como dep�sito","deposito", transacao.getTipo());
		assertEquals("Deve ter sido registrado o valor da transa��o",500, transacao.getValor(),0);
		assertEquals("Deve ter sido registrado o saldo da conta corrente com o desconto de 10 centavos",499.9, cc.getSaldo(),0);

		//Testa saque
		assertFalse(GerenciadorDeTransacoes.saque(cc, 10000000));
		assertEquals("Essa transa��o n�o foi registrada pois n�o foi poss�vel realizar o saque", 1, cc.getTransacoes().size());

		//Testa novamente saque
		assertTrue(GerenciadorDeTransacoes.saque(cc, 10));
		transacao = cc.getTransacoes().get(1);
		assertEquals("O nome do cliente da conta que fez a transacao � Rodrigo",
				"Rodrigo", transacao.getConta().getCliente().getNome());
		assertEquals("A conta deve ser a mesma criada",cc, transacao.getConta());
		assertNotNull("Deve ter sido registrado o dia",transacao.getDia());
		assertNotNull("Deve ter sido registrado o dia",transacao.getHora());
		assertEquals("Deve ter sido registrado o tipo da transa��o como dep�sito","saque", transacao.getTipo());
		assertEquals("Deve ter sido registrado o valor da transa��o",10, transacao.getValor(),0);
		assertEquals("Deve ter sido registrado o saldo da conta corrente com o desconto de 10 centavos",489.9, cc.getSaldo(),0);

		
	}
	
//	@Test
//	public void testaSaque() {
//		fail("Falta implementar semelhante ao dep�sito");
//	}

}
