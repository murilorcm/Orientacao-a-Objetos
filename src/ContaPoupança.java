public class ContaPoupança extends Conta {

    @Override
    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 3;
    }

    @Override
    public void deposita(double valor) {
        this.saldo += valor - 0.10;
    }
}
