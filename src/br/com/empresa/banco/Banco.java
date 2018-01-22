package br.com.empresa.banco;

import br.com.empresa.banco.conta.Conta;
import br.com.empresa.banco.conta.ContaCorrente;
import br.com.empresa.banco.conta.ContaPoupança;
import br.com.empresa.banco.sistema.ValorInvalidoException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {

    private static final int MAX = 44;
    protected static Map<Integer, Conta> contas = new HashMap<Integer, Conta>();

    public static void main(String[] args) throws ValorInvalidoException {

        Random random = new Random();

        for (int i = 0; i < MAX; i++){
            criarConta(i, random.nextInt(9999), random.nextInt(2));
        }

        pegarConta(random.nextInt(MAX));
        quantidadeDeContas();


    }

    public static void pegarConta(int numero) {
        System.out.println(contas.get(numero));
    }

    public static void quantidadeDeContas() {
        System.out.println("Total de Contas: " + contas.size());
    }


    public static void criarConta(int numero, int saldo, int tipo) throws ValorInvalidoException {

        Conta c;

        switch (tipo) {
            case 0:
                c = new ContaPoupança(numero);
                c.deposita(saldo);
                c.setTipo("CONTA POUPANÇA");
                break;

            case 1:
                c = new ContaCorrente(numero);
                c.deposita(saldo);
                c.setTipo("CONTA CORRENTE");
                break;

            default:
                c = null;
        }
        contas.put(c.getNumero(), c);
    }
}
