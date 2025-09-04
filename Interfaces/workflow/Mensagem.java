public class Mensagem {
    private String texto;
    private TipoMensagem tipo;
    
    public Mensagem(String texto, TipoMensagem tipo) {
        this.setTexto(texto);
        this.setTipo(tipo);
    }

    public String getTexto() {
        return texto;
    }

    private void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoMensagem getTipo() {
        return tipo;
    }

    private void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    
}
