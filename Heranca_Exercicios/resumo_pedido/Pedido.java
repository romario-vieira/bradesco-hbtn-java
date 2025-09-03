public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.setPercentualDesconto(percentualDesconto);
        this.setItens(itens);
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        double desconto = total * (this.getPercentualDesconto() / 100);
        return total - desconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            System.out.printf("Tipo: %s%n", item.getProduto().getClass().getSimpleName() + "  " 
                                    + "Titulo: " + item.getProduto().getTitulo() + "  " 
                                    + "Preco: " + String.format("%.2f", item.getProduto().obterPrecoLiquido()) + "  " 
                                    + "Quant: " + item.getQuantidade() + "  " 
                                    + "Total: " + String.format("%.2f", item.getProduto().obterPrecoLiquido() * item.getQuantidade()));
                                    totalProdutos += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }

        double totalPedidos = this.calcularTotal();
        double desc = totalProdutos * (this.getPercentualDesconto() / 100);

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f%n", desc);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedidos);
        System.out.println("----------------------------");
    }
}