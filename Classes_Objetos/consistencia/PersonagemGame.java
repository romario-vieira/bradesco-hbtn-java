public class PersonagemGame {
    private String nome;
    private int saudeAtual;
    private String status;

    public PersonagemGame(int saudeInicial, String nome) {
        this.nome = nome;
        this.setSaudeAtual(saudeInicial);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if( nome == null || nome.isEmpty()) {
            return;
        }
        this.nome = nome;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }
    
    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if (saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public void tomarDano(int quantidadeDeDano) {
        this.setSaudeAtual(saudeAtual - quantidadeDeDano);
        if (this.saudeAtual < 0) {
            this.setSaudeAtual(0);
        }
    }

    public void receberCura(int quantidadeDeCura) {
        this.setSaudeAtual(saudeAtual + quantidadeDeCura);
        if (this.saudeAtual > 100) {
            this.setSaudeAtual(100);
        }
    }

    public String getStatus() {
        return status;
    }
}