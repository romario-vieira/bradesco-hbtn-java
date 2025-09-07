import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor > 0) {
            if (valor > saldo) {
                throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
            }
            saldo -= valor;
        } else {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
    }

    public double calcularTarifaMensal() {
        double tarifa = saldo * 0.1;
        if (tarifa > 10) {
            tarifa = 10;
        }
        return tarifa;
    }

    public double calcularJurosMensal() {
        if (saldo < 0) {
            return 0;
        }
        return (saldo * (taxaJurosAnual / 100)) / 12;
    }

    public void aplicarAtualizacaoMensal() {
        double tarifa = calcularTarifaMensal();
        double juros = calcularJurosMensal();
        saldo = saldo - tarifa + juros;
    }
}