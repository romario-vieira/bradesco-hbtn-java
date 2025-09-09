import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura


        // efetue a leitura do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Conteúdo do arquivo 'exemplo.txt':\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\nLeitura do arquivo concluída.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}