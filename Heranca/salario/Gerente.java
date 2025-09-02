public class Gerente extends Empregado {
    private double comissao;

    public Gerente(double salarioFixo) {
        super(salarioFixo);
        this.comissao = salarioFixo * 0.20;
    }

    public double getComissao() {
        return comissao;
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        double bonusFixo = super.calcularBonus(departamento);
        if (departamento.alcancouMeta()) {
            return bonusFixo + comissao;
        }
        return 0;
    }

    @Override
    public double calcularSalarioTotal(Departamento departamento) {
        return getSalarioFixo() + calcularBonus(departamento);
    }
}