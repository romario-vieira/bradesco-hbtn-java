public class SistemaFilas {
    
    public static void main(String[] args) throws InterruptedException {
        Fila fila1 = new Fila(10);

        Produtor produtor1 = new Produtor(fila1);
        Produtor produtor2 = new Produtor(fila1);
        Consumidor consumidor = new Consumidor(fila1);
        Consumidor consumidor2 = new Consumidor(fila1);

        produtor1.start();
        produtor2.start();

        produtor1.join();
        produtor2.join();

        consumidor.start();
        consumidor2.start();


        Thread.sleep(20000);
        System.out.println("Programa terminado. Tamanho final da fila: " + fila1.getFila().size());
        System.exit(0); // Encerra todas as threads
    }
}
