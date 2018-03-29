package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private Cliente cliente;

	@Before
	public void setup() {
		cliente = new Cliente();
	}
	
	@Test
	public void testaAdicionaContas(){
		assertFalse("Não se pode inserir conta nula", cliente.adicionaConta(null));
		Conta cc = new ContaCorrente();
		Cliente cliente = new Cliente();
		cliente.setNome("Rodrigo");
		assertTrue("Conta inserida", cliente.adicionaConta(cc));
		assertEquals("A única conta recuperada de índice 0 é do Rodrigo", "Rodrigo", 
				cliente.getContas().get(0).getCliente().getNome());
	}
	
	
	@Test
	public void testaTotalContaCorrente(){
		assertEquals("O saldo da conta corrente de cliente sem conta é zero", 0, 
				cliente.getTotalContaCorrente(), 0);
		
		Conta cc1 = new ContaCorrente();
		cc1.setSaldo(1000);
		cliente.adicionaConta(cc1);
		assertEquals("O saldo da conta corrente é 1000", 1000, 
				cliente.getTotalContaCorrente(), 0);

		
		Conta cc2 = new ContaCorrente();
		cc2.setSaldo(500);
		cliente.adicionaConta(cc2);
		
		assertEquals("O saldo da conta corrente é 1500 (1000 + 500) ", 1500, 
				cliente.getTotalContaCorrente(), 0);
		
		Conta cp1 = new ContaPoupanca();
		cp1.setSaldo(2000);
		cliente.adicionaConta(cp1);
		
		assertEquals("O saldo da conta corrente continua 1500 pois não se considera poupança", 
				1500, cliente.getTotalContaCorrente(), 0);
	}
	
	@Test
	public void testaTotalPoupanca(){
		assertEquals("O saldo da conta corrente de cliente sem conta é zero", 0, 
				cliente.getTotalPoupanca(), 0);
		
		Conta cc1 = new ContaPoupanca();
		cc1.setSaldo(1000);
		cliente.adicionaConta(cc1);
		assertEquals("O saldo da conta poupança é 1000", 1000, 
				cliente.getTotalPoupanca(), 0);

		
		Conta cc2 = new ContaPoupanca();
		cc2.setSaldo(500);
		cliente.adicionaConta(cc2);
		
		assertEquals("O saldo da conta poupança é 1500 (1000 + 500) ", 1500, 
				cliente.getTotalPoupanca(), 0);
		
		Conta cp1 = new ContaCorrente();
		cp1.setSaldo(2000);
		cliente.adicionaConta(cp1);
		
		assertEquals("O saldo da conta poupança continua 1500 pois não se considera conta corrente", 
				1500, cliente.getTotalPoupanca(), 0);
	}
	
}
