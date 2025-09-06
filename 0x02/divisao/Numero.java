public class Numero {
    
    public static void dividir(int a, int b) {
        int divisao = 0;
        try {
            divisao = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Nao eh possivel dividir por zero");
        } finally {
            System.out.println("%s / %s = %s".formatted(a, b, divisao));
        }
    }
}