public class TesteContas {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        ContaPoupança cp = new ContaPoupança();

        cc.deposita(1000);
        cp.deposita(1000);

        AtualizadorDeContas adc = new AtualizadorDeContas(0.1);

        adc.roda(cc);
        adc.roda(cp);

        System.out.printf("===========================\n" + "SaldoTotal: %.2f\n", adc.getSaldoTotal());

        System.out.printf("Tributo Conta Corrente: R$%.2f", cc.calculaTributos());

        Tributavel t = new SeguroDeVida();

        System.out.printf("\nTributo Seguro de Vida: R$%.2f\n", t.calculaTributos());
    }
}
