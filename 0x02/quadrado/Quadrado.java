public class Quadrado {
        public static double area(double lado) throws Exception {
            if (lado < 0) {
                throw new IllegalArgumentException("Lado deve possuir valor positivo");
            }
            return lado * lado;
        }
    }