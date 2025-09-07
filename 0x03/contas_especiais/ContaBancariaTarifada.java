import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        try {
            valor = valor - 0.1;
            super.depositar(valor);
        } catch (RuntimeException e) {
            throw new OperacaoInvalidaException(e.getMessage());
        }
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        try {
            super.sacar(valor + 0.1);
        } catch (RuntimeException e) {
            throw new OperacaoInvalidaException(e.getMessage());
        }
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    
}