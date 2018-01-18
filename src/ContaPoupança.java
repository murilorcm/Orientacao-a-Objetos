public class ContaPoupança extends Conta {

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
}
