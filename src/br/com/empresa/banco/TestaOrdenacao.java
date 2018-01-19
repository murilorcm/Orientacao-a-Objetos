package br.com.empresa.banco;

import br.com.empresa.banco.conta.Conta;
import br.com.empresa.banco.conta.ContaCorrente;
import br.com.empresa.banco.conta.ContaPoupança;
import br.com.empresa.banco.sistema.ValorInvalidoException;

import java.util.*;

public class TestaOrdenacao {
    public static void main(String[] args) throws ValorInvalidoException {
        List<Conta> agencia = new LinkedList<Conta>();
        int i;
        Random random = new Random();

        for (i = 5; i > 0; i--) {
            agencia.add(CriarConta(i, random.nextInt(9999), random.nextInt(2)));
        }

        Collections.shuffle(agencia);

        for (Conta conta : agencia) {
            System.out.println("Número: " + conta.getNumero() + " | Tipo: " + conta.getTipo() + " | Saldo: R$" + conta.getSaldo());
        }

        System.out.println("-------------------");

        Collections.sort(agencia);

        for (Conta conta : agencia) {
            System.out.println("Número: " + conta.getNumero() + " | Tipo: " + conta.getTipo() + " | Saldo: R$" + conta.getSaldo());
        }

    }

    public static Conta CriarConta ( int numero, int saldo, int tipo) throws ValorInvalidoException {

        Conta c = null;

        switch (tipo) {
            case 0: c = new ContaPoupança(numero);
                    c.deposita(saldo);
                    c.setTipo("CONTA POUPANÇA");
                    break;

            case 1: c = new ContaCorrente(numero);
                    c.deposita(saldo);
                    c.setTipo("CONTA CORRENTE");
                    break;

            default: c = null;
        }

        return c;
    }

}

