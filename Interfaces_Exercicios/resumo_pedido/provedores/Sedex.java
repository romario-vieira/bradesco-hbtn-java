package provedores;


public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double custo;
        if (peso > 1000) {
            custo = (0.1 * valor);
        } else {
            custo = (0.05 * valor);
        }
        return new Frete(custo, TipoProvedorFrete.SEDEX);
    }
    
    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}