import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno("João", 20);
        alunos.add(aluno);
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void excluirAluno(String nome) {
        alunos.removeIf(aluno -> aluno.getNome().equals(nome));
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Pedro", 18);
        gestao.adicionarAluno("Ana", 30);
        gestao.listarAlunos();
        gestao.buscarAluno("João");
        gestao.excluirAluno("Pedro");
        gestao.excluirAluno("Maria");
        gestao.buscarAluno("Ana");
    }
}
