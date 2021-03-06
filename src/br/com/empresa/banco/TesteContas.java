package br.com.empresa.banco;

import br.com.empresa.banco.conta.ContaCorrente;
import br.com.empresa.banco.conta.ContaPoupança;
import br.com.empresa.banco.conta.SeguroDeVida;
import br.com.empresa.banco.conta.Tributavel;
import br.com.empresa.banco.sistema.AtualizadorDeContas;
import br.com.empresa.banco.sistema.GerenciadorDeImpostoDeRenda;
import br.com.empresa.banco.sistema.ValorInvalidoException;

public class TesteContas {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(22);
        ContaPoupança cp = new ContaPoupança(22);
        Tributavel sv = new SeguroDeVida();

        System.out.println("Iniciando depósito em conta corrente");
        try {
            cc.deposita(1000);
            System.out.println("Depósito efetuado com sucesso!");
        } catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizando operação!");
        }

        System.out.println("Iniciando depósito em conta poupança");
        try {
            cp.deposita(-10);
            System.out.println("Depósito efetuado com sucesso!");
        } catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizando operação!");
        }

        cc.saca(3);

        AtualizadorDeContas adc = new AtualizadorDeContas(0.1);
        GerenciadorDeImpostoDeRenda gir = new GerenciadorDeImpostoDeRenda();

        adc.roda(cc);
        adc.roda(cp);

        System.out.printf("===========================\n" + "SaldoTotal: %.2f\n", adc.getSaldoTotal(), "===========================\n");

        System.out.printf("\nTributo br.com.empresa.banco.conta.Conta Corrente: R$%.2f\n", cc.calculaTributos());
        gir.adiciona(cc);

        System.out.printf("\nTributo Seguro de Vida: R$%.2f\n", sv.calculaTributos());
        gir.adiciona(sv);

        System.out.printf("\nTotal de tritubos: R$%.2f\n", gir.getTotal());

        System.out.println(cp.toString());

        String texto ="Murilo é muito legal";
        texto.split(" ");
    }
}
