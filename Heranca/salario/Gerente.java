public class Gerente extends Empregado {
    private double comissao;

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    public double getComissao(Departamento departamento) {
        double meta = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
        return comissao += meta * 0.01;
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return super.getSalarioFixo() * 0.20 + this.getComissao(departamento);
        }
        return 0;
    }

    @Override
    public double calcularSalarioTotal(Departamento departamento) {
        return getSalarioFixo() + calcularBonus(departamento);
    }
}