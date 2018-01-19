package br.com.empresa.banco.conta;

import br.com.empresa.banco.sistema.ValorInvalidoException;
import org.jetbrains.annotations.NotNull;

public class ContaPoupança extends Conta {// implements Comparable<ContaPoupança> {

    public ContaPoupança(int numero) {
        super(numero);
    }

    @Override
    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 3;
    }

    @Override
    public void deposita(double valor) throws ValorInvalidoException {
        if (valor < 0){
            throw new ValorInvalidoException("Você tentou depositar um valor negativo");
        } else {
            this.saldo += valor - 0.10;
        }
    }

    //@Override
    //public int compareTo(@NotNull ContaPoupança outra) {
    //    return this.getNumero() - outra.getNumero();
    //}
}
