// Classe para controle financeiro
import java.util.ArrayList;

public class ControleFinanceiro {

    // Lista de transações
    private ArrayList<Transacao> transacoes;

    // Construtor
    public ControleFinanceiro() {
        transacoes = new ArrayList<>();
    }

    // Adiciona uma transação
    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    // Lista todas as transações
    public void listarTransacoes() {

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada.");
            return;
        }

        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }

    // Calcula o saldo total
    public double calcularSaldo() {

        double saldo = 0;

        for (Transacao t : transacoes) {

            if (t.getTipo() == TipoTransacao.RECEITA) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }

        return saldo;
    }
}