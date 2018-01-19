package br.com.empresa.banco.conta;

import br.com.empresa.banco.sistema.ValorInvalidoException;
import org.jetbrains.annotations.NotNull;

public abstract class Conta implements Comparable<Conta> {
    protected double saldo;
    protected int numero;
    protected String tipo = "CONTA";

    public Conta(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

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

    @Override
    public String toString() {
        return "Número: " + getNumero() + " Saldo: " + getSaldo();
    }

    @Override
    public boolean equals(Object obj) {
        Conta outraConta = (Conta) obj;

        return this.numero == outraConta.numero;
    }

    @Override
    public int compareTo(@NotNull Conta outra) {
        return this.getNumero() - outra.getNumero();
    }
}

