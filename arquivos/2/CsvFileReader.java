import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("Conteúdo do arquivo 'funcionarios.csv':\n");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Funcionário: " + values[0] + "\n" + "Idade: " + values[1] + "\n" + "Departamento: " + values[2] + "\n" + "Salarial: " + values[3]);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
