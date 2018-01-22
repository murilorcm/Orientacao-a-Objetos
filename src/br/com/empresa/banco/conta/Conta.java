package br.com.empresa.banco.conta;

import br.com.empresa.banco.sistema.ValorInvalidoException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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
        return "Número: " + this.getNumero() + " | Tipo: " + this.getTipo() + " | Saldo: R$" + this.getSaldo();
    }

    @Override
    public int compareTo(@NotNull Conta outra) {
        return this.getNumero() - outra.getNumero();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero;
    }

    @Override
    public int hashCode() {

        return Objects.hash(numero);
    }
}

