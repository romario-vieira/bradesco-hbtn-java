public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        int numThreads = 2;

        for (int i = 0; i < numThreads; i++) {
            ThreadContador thread = new ThreadContador(contador);
            thread.start();
            thread.join();
        }

        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
