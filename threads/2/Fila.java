import java.util.LinkedList;

public class Fila {
    private LinkedList<Integer> fila;

    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        fila = new LinkedList<>();
    }
    
    public synchronized void adicionar(int item) throws InterruptedException {
        fila.add(item);
        notify(); // Notifica um consumidor que um item foi adicionado
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // Espera até que haja um item na fila
        }
        return fila.removeFirst();
    }

    public LinkedList<Integer> getFila() {
        return fila;
    }

    public int getCapacidade() {
        return capacidade;
    }
    
}
