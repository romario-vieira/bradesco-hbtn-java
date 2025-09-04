public class Mensagem {
    private String texto;
    private TipoMensagem tipoMensagem;
    
    public Mensagem(String texto, TipoMensagem tipoMensagem) {
        this.setTexto(texto);
        this.setTipoMensagem(tipoMensagem);
    }

    public String getTexto() {
        return texto;
    }

    private void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    private void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    
}
