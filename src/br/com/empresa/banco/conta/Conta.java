package br.com.empresa.banco.conta;

import br.com.empresa.banco.sistema.ValorInvalidoException;

public abstract class Conta {
    protected double saldo;

    public double getSaldo() {
        return this.saldo;
    }

    public void deposita(double valor) throws ValorInvalidoException {

        if (valor < 0){
            throw new ValorInvalidoException("Você tentou depositar um valor negativo");
        } else {
            this.saldo += valor;
        }
    }

    public void saca(double valor) { this.saldo -= valor; }

    public abstract void atualiza(double taxa);
}

