package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContaCorrenteTest {

	Conta cc;

	@Before
	public void setup() {
		cc = new ContaCorrente();
	}

	@Test
	public void testDeposita() {
		cc.deposita(1000);
		assertEquals(
				"Apos o deposito de 1000, o saldo deve ser 1000 menos 10 centavos",
				999.9, cc.getSaldo(), 1);
	}

	@Test
	public void testAtualiza() {
		cc.deposita(1000);
		cc.atualiza(0.01);
		assertEquals("Novo saldo eh Saldo original mais dobro da taxa",
				1019.898, cc.getSaldo(), 3);
	}

	@Test
	public void testOrdenacao() {
		List<ContaCorrente> contas = new ArrayList<>();
        
		ContaCorrente  c1 = new ContaCorrente();
        c1.setSaldo(1973);
        contas.add(c1);
        
        ContaCorrente c2 = new ContaCorrente();
        c2.setSaldo(1462);
        contas.add(c2);
        
        ContaCorrente c3 = new ContaCorrente();
        c3.setSaldo(1854);
        contas.add(c3);
        
        assertEquals("O primeiro elemento eh 1973", 1973, contas.get(0).getSaldo(),0);
        assertEquals("O segundo elemento eh 1462", 1462, contas.get(1).getSaldo(),0);
        assertEquals("O terceiro elemento eh 1854", 1854, contas.get(2).getSaldo(),0);
        
        Collections.sort(contas); //A ordenação da conta poupança é pela diferenca do saldo 
        										//da conta pelo informado (faça cast para int)
        
        assertEquals("O primeiro elemento eh 1462", 1462, contas.get(0).getSaldo(),0);
        assertEquals("O segundo elemento eh 1854", 1854, contas.get(1).getSaldo(),0);
        assertEquals("O terceiro elemento eh 1973", 1973, contas.get(2).getSaldo(),0);
	}
}
