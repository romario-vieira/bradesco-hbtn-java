import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedidoCookie : cookies) {
            total += pedidoCookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
    int totalRemovido = 0;
    List<PedidoCookie> paraRemover = new ArrayList<>();
    for (PedidoCookie pedidoCookie : cookies) {
        if (pedidoCookie.getSabor().equals(sabor)) {
            totalRemovido += pedidoCookie.getQuantidadeCaixas();
            paraRemover.add(pedidoCookie);
        }
    }
    cookies.removeAll(paraRemover);
    return totalRemovido;
}
}
