public class Sms implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.println("[SMS] {" + mensagem.getTipo() + "} - " + mensagem.getTexto());
    }
}
