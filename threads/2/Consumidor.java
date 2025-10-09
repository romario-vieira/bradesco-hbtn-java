public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            if (fila.getFila().isEmpty()) {
                synchronized (fila) {
                    fila.wait(); // Espera até que haja um item na fila
                }
            }

            int tamFila = fila.getFila().size();

            for (int i = 1; i <= tamFila; i++) {
                int item = fila.retirar(); // O consumidor retira os itens da fila
                System.out.println("Consumidor retirou: " + item);
                Thread.sleep(500); // Simula o tempo para consumir um item
            }
            if (fila.getFila().isEmpty()) {
                synchronized (fila) {
                    fila.notifyAll(); // Notifica o produtor que todos os itens foram consumidos
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
