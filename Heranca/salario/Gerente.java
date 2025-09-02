public class Gerente extends Empregado {
    private double comissao;

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