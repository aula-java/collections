package br.edu.ifrs.canoas.java.banco.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.ContaCorrente;
import br.edu.ifrs.canoas.java.banco.entidade.SeguroDeVida;
import br.edu.ifrs.canoas.java.banco.entidade.Tributavel;

public class GerenciadorDeImpostoDeRendaTest {

	GerenciadorDeImpostoDeRenda gerenciador;

	@Before
	public void setup() {
		gerenciador = new GerenciadorDeImpostoDeRenda();
	}

	@Test
	public void testAdicionaSeguroEContaCorrente() {
		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);
		assertEquals("O valor do tributo para o seguro de vida Ž fixo e igual a 42", 42, gerenciador.getTotal(), 0);
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);//Dep—sito de 1000 gera saldo de 999.9 (cada dep—sito tem um custo de 10 centavos)
		gerenciador.adiciona(cc);
		assertEquals("O valor do tributo para a conta corrente Ž 1% do saldo (10% de 999.99 + 42 do seguro de vida)", 51.99, gerenciador.getTotal(), 2);


	}
	
	@Test
	public void testAdicionaComInterface() {
		Tributavel trib = new SeguroDeVida();
		gerenciador.adiciona(trib);
		assertEquals("O valor do tributo para o seguro de vida Ž fixo e igual a 42", 42, gerenciador.getTotal(), 0);
	}

}
