package br.edu.ifrs.canoas.java.banco;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ br.edu.ifrs.canoas.java.banco.entidade.AllTests.class, br.edu.ifrs.canoas.java.banco.controle.AllTests.class })
public class AllTests {

}
