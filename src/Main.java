import com.banco.domain.model.Banco;
import com.banco.domain.model.Cliente;
import com.banco.domain.model.Conta;
import com.banco.domain.model.ContaCorrente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("CASH! & MONEY!") ;
        System.out.println("Bem-Vindo!");
        System.out.printf("Escolha:" +
                "\n1 - Criar Conta" +
                "\n2 - Imprimir Extrato" +
                "\n3 - Sacar" +
                "\n4 - Depositar" +
                "\n5 - Transferir" +
                "\n6 - Sair" +
                "\n Escolha: ");
        int escolha = scanner.nextInt();
        switch (escolha){
            case 1 -> {
                try {
                    String nome = "";
                    System.out.println("Criação de conta: ");
                    System.out.printf("Insira seu nome: ");
                    scanner.nextLine(); // limpa buffer
                    nome = scanner.nextLine();
                    Conta conta = null; // optional?
                    Cliente cliente = new Cliente(nome);
                    System.out.printf("\nDigite 1 para criar uma conta Corrente. \n" +
                            "Digite 2 para criar uma conta Poupanca." +
                            "\nEscolha: ");
                    escolha = scanner.nextInt();
                    if (escolha == 1) {
                        conta = new ContaCorrente(cliente);
                    } else {
                        conta = new ContaCorrente(cliente);
                    }
                    banco.persistirConta(conta);
                    System.out.println("Conta criada!");
                }catch (Exception e){// personalizar?
                    System.out.println("Erro." + e);
                }
            }
            case 2 -> {
                System.out.println("Insira o número da sua conta");
            }

            default -> System.out.println("Tente novamente.");
        }
        System.out.println(banco.getContas());
    }
}