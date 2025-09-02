public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    public double getComissao(Departamento departamento) {
        double meta = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
        return meta * 0.01;
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double com = this.getComissao(departamento);
            return super.getSalarioFixo() * 0.20 + com;
        }
        return 0;
    }

    @Override
    public double calcularSalarioTotal(Departamento departamento) {
        double bonus = this.calcularBonus(departamento);
        return getSalarioFixo() + bonus;
    }
}