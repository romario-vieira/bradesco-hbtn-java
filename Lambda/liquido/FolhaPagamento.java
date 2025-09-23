public class FolhaPagamento {
    public static double calcularLiquido(Funcionario funcionario, CalculadorDeSalario calculador) {
        double salarioBase = funcionario.getSalario();
        double salarioLiquido = calculador.calcular(salarioBase);
        return salarioLiquido;
    }
}
