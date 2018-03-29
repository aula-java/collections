## [Módulo 1: Programação Java](https://aula-java.github.io/aulas/modulo-1.html)

### [Exercício: Implementaçoes: Collections](https://aula-java.github.io/aulas/implementacao/#/1)

1. Clone o projeto faça as alterações para que passe no teste unitário.

<img height="400" src="https://aula-java.github.io/aulas/implementacao/collections/exerc-1.png">

2. Altere o projeto de forma que a classe Cliente armazene todas as suas contas e mantenha a consistência. Para isso, o método Cliente.adicionaConta deve incluir a instrução "conta.setCliente(this);" antes de adicionar a conta na lista de contas do cliente. O projeto deve passar pelos testes unitários. Dica: para saber se um objeto é instância de uma classe, use o operador instanceof (por exemplo, para saber se uma conta é conta corrente ou poupança).   

3. Adicione um entidade de Transação para gerenciar todas as transações de uma conta bancária. Uma transação só pode ser de saque ou depósito e deve obrigatoriamente registrar o dia, hora (defina ambos campos como String), valor, conta e tipo ("deposito" ou "saque"). Ao final, o projeto deve passar pelo teste unitário GerenciadorDeTransacoesTest. Não se esqueça de implementar o método testaSaque() de forma semelhante ao método testaDeposito(). Use sempre as melhores práticas de codificação para evitar redundância de código.   
