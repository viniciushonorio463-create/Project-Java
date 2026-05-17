import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    static ControleFinanceiro controle = new ControleFinanceiro();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== CONTROLE FINANCEIRO =====");
            System.out.println("1 - Adicionar Receita");
            System.out.println("2 - Adicionar Despesa");
            System.out.println("3 - Listar Transações");
            System.out.println("4 - Mostrar Saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    adicionarTransacao(
                            scanner,
                            controle,
                            TipoTransacao.RECEITA
                    );
                    break;

                case 2:
                    adicionarTransacao(
                            scanner,
                            controle,
                            TipoTransacao.DESPESA
                    );
                    break;

                case 3:
                    controle.listarTransacoes();
                    break;

                case 4:

                    NumberFormat formato =
                            NumberFormat.getCurrencyInstance(
                                    new Locale("pt", "BR")
                            );

                    System.out.println(
                            "\nSaldo atual: " +
                                    formato.format(
                                            controle.calcularSaldo()
                                    )
                    );

                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void adicionarTransacao(
            Scanner scanner,
            ControleFinanceiro controle,
            TipoTransacao tipo) {

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        try {

            Transacao transacao =
                    new Transacao(
                            descricao,
                            valor,
                            tipo
                    );

            controle.adicionarTransacao(transacao);

            System.out.println("Transação adicionada!");

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}