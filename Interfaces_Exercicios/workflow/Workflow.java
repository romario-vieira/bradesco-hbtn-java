import java.util.List;

import atividades.Atividade;

public class Workflow {

    private List<Atividade> atividades;

    public Workflow() {
        atividades = new java.util.ArrayList<>();
    }

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
    
}