package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double custo;
        if (peso > 5000) {
            custo = (0.12 * valor);
        } else {
            custo = (0.04 * valor);
        }
        return new Frete(custo, TipoProvedorFrete.LOGGI);
    }
    

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}