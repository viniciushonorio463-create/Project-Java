import java.text.NumberFormat;
import java.util.Locale;

public class Transacao {

    private String descricao;
    private double valor;
    private TipoTransacao tipo;

    public Transacao(String descricao, double valor, TipoTransacao tipo) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    @Override
    public String toString() {

        NumberFormat nf =
                NumberFormat.getCurrencyInstance(
                        new Locale("pt", "BR")
                );

        return "Tipo: " + tipo +
                " | Descrição: " + descricao +
                " | Valor: " + nf.format(valor);
    }
}