package provedores;

public class JadLog implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double custo;
        if (peso > 2000) {
            custo = (0.07 * valor);
        } else {
            custo = (0.045 * valor);
        }
        return new Frete(custo, TipoProvedorFrete.JADLOG);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

}