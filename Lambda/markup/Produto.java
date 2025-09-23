import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto implements Supplier<Double>, Consumer<Double> {
    private double preco;
    private String nome;
    private double percentualMarkup;
    public Supplier<Double> precoComMarkup;
    public Consumer<Double> atualizarMarkup;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
        this.percentualMarkup = 10;
        this.precoComMarkup = this::get;
        this.atualizarMarkup = this::accept;
    }

    @Override
    public Double get() {
        // Returns the price with markup applied
        return preco + (preco * percentualMarkup / 100);
    }

    @Override
    public void accept(Double novoMarkup) {
        // Updates the percentualMarkup with the provided value
        this.percentualMarkup = novoMarkup;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
