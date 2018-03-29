package br.edu.ifrs.canoas.java.banco.entidade;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgenciaTest.class, ClienteTest.class, ContaCorrenteTest.class, ContaPoupancaTest.class })
public class AllTests {

}
