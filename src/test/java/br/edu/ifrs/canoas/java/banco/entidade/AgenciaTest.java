package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AgenciaTest {
	
	private Agencia agencia;
	
	@Before
	public void setup(){
		agencia = new Agencia();
	}

	@Test
	public void testAgencia() {
		Conta conta = new ContaCorrente();
		conta.setSaldo(1000);
		agencia.adicionaConta(conta);
		assertEquals("O saldo total da agencia eh 1000", 1000, agencia.getSaldoTotal(),0);
		
		conta = new ContaPoupanca();
		conta.setSaldo(500);
		agencia.adicionaConta(conta);
		assertEquals("O saldo total da agencia eh 1000+500", 1500, agencia.getSaldoTotal(),0);
		
	}

}
