 import java.io.BufferedWriter;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;


 public class FileWritingExercise {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);


         // Solicita o nome do arquivo
         System.out.print("Digite o nome do arquivo (com extensão .txt): ");
         String fileName = scanner.nextLine();
         
         // implemente o codigo aqui
        
        
         // Solicita o conteúdo a ser escrito no arquivo
        while (true) {
            System.out.print("Digite o conteúdo a ser escrito no arquivo: ");
            String content = scanner.nextLine();
            if (content.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa.");
                break;
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(content);
                writer.newLine();
                System.out.println("Conteúdo escrito no arquivo com sucesso.");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
            }
            
        }

         scanner.close();
     }
 }