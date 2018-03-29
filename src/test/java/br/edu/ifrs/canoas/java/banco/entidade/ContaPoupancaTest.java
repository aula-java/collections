package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.Conta;
import br.edu.ifrs.canoas.java.banco.entidade.ContaPoupanca;

public class ContaPoupancaTest {

	Conta cp;
	
	@Before
	public void setup(){
		cp = new ContaPoupanca();
	}
	
	@Test
	public void testAtualiza() {
		cp.deposita(1000);
		cp.atualiza(0.01);
		assertEquals("Novo saldo eh Saldo original (999.9) mais triplo da taxa (3x.01)", 1030, cp.getSaldo(),0);
	}
	
	@Test
	public void testOrdenacao() {
		List<ContaPoupanca> contas = new ArrayList<>();
        
		ContaPoupanca c1 = new ContaPoupanca();
        c1.setNumero(1973);
        contas.add(c1);
        
        ContaPoupanca c2 = new ContaPoupanca();
        c2.setNumero(1462);
        contas.add(c2);
        
        ContaPoupanca c3 = new ContaPoupanca();
        c3.setNumero(1854);
        contas.add(c3);
        
        assertEquals("O primeiro elemento eh 1973", 1973, contas.get(0).getNumero());
        assertEquals("O segundo elemento eh 1462", 1462, contas.get(1).getNumero());
        assertEquals("O terceiro elemento eh 1854", 1854, contas.get(2).getNumero());
        
        Collections.sort(contas); //A ordenação da conta poupança é pelo seu número
        
        assertEquals("O primeiro elemento eh 1462", 1462, contas.get(0).getNumero());
        assertEquals("O segundo elemento eh 1854", 1854, contas.get(1).getNumero());
        assertEquals("O terceiro elemento eh 1973", 1973, contas.get(2).getNumero());
	}
}
