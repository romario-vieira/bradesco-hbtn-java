import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private String nomeArquivo;

    public Estoque(String nomeArquivo) {
        this.setNomeArquivo(nomeArquivo);
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getNomeArquivo(), true))) {
            int id = (int) (Math.random() * 10000); // Gera um ID aleatório
            String linha = id + "," + nome + "," + quantidade + "," + preco;
            writer.write(linha);
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluirProduto(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(getNomeArquivo()));
            List<String> conteudo = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                List<String> partes = List.of(linha.split(","));
                if (Integer.parseInt(partes.get(0)) != id) {
                    conteudo.add(linha);
                }
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(getNomeArquivo()));
            for (String gravar : conteudo) {
                bw.write(gravar);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exibirEstoque() {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(this.getNomeArquivo()));
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        // Implementação para atualizar a quantidade de um produto no arquivo CSV
        try {
            BufferedReader br = new BufferedReader(new FileReader(getNomeArquivo()));
            List<String> conteudo = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (Integer.parseInt(partes[0]) == id) {
                    partes[2] = String.valueOf(novaQuantidade);
                    linha = String.join(",", partes);
                }
                conteudo.add(linha);
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(getNomeArquivo()));
            for (String l : conteudo) {
                bw.write(l);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
