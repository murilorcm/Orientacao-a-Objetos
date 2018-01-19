package br.com.empresa.banco.conta;

public class ContaCorrente extends Conta implements Tributavel {

    protected String tipo = "CONTA CORRENTE";

    public ContaCorrente(int numero) {
        super(numero);
    }

    @Override
    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 2;
    }

    @Override
    public double calculaTributos() {
        return this.getSaldo() * 0.01;
    }
}