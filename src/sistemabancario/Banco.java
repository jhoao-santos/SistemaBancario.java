package sistemabancario;

public class Banco {
    void depositar(Conta conta, double valor) {
        double saldoAtual = conta.saldo;
        double novoSaldo = saldoAtual + valor;
        conta.saldo = novoSaldo;
    }

    void sacar(Conta conta,double valor) {
        double saldoAtual =  conta.saldo;
        double novoSaldo = saldoAtual - valor;
        if (novoSaldo < 0 ) {
            System.out.println("Não foi possivel sacar!  Saldo ficará insuficiente!");
        } else {
            conta.saldo = novoSaldo;
        }
    }

    void transferir(Conta origem, Conta destino, double valor) {

        double saldoAtualorigem = origem.saldo;
        double  novoSaldoOrigem = saldoAtualorigem - valor;
        if (novoSaldoOrigem < 0 ) {
            System.out.println("Transferencia não realizada! Saldo ficará insuficiente" );
        } else {
            origem.saldo = novoSaldoOrigem;
            double novoSaldoDestino = destino.saldo + valor;
            destino.saldo = novoSaldoDestino;
        }

    }
}
