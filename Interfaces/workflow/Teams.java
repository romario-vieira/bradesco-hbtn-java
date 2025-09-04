public class Teams implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.println("[TEAMS] {" + mensagem.getTipo() + "} - " + mensagem.getTexto());
    }

}
