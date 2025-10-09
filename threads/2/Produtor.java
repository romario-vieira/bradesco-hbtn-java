import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private int tamanhoFila;

    public Produtor(Fila fila) {
        this.fila = fila;
        this.tamanhoFila = fila.getCapacidade();
    }

    @Override
    public void run() {
        try {

            if(fila.getFila().size() == tamanhoFila) {
                synchronized(fila) {
                    fila.wait(); // Espera até que haja espaço na fila
                }
            }

            for (int i = 1; i <= tamanhoFila; i++) {
                Random rand = new Random();
                int numAleatorio = rand.nextInt(100);
                fila.adicionar(numAleatorio);  // O produtor coloca os itens na fila
                System.out.println("Produtor produziu: " + numAleatorio);
                Thread.sleep(1000);   // Simula o tempo para produzir um item
            }
            if(fila.getFila().size() == tamanhoFila) {
                synchronized(fila) {
                    fila.notifyAll(); // Notifica os consumidores que a produção terminou
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
