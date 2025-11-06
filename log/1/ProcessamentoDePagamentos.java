import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) {


    // implemente o codigo necessario para resolucao do problema
    Random random = new Random();
    int totalPagamentos = 5;

    List<String> statusPagamentos = List.of("SUCESSO", "FALHA", "PENDENTE");
    
    for (int i = 1; i <= totalPagamentos; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);
            // Simula o processamento do pagamento com um status aleatório
            String status = statusPagamentos.get(random.nextInt(statusPagamentos.size()));
            if (status.equals("SUCESSO")) {
                logger.info("Pagamento {} processado com sucesso.", i);
            } else if (status.equals("FALHA")) {
                logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
            } else {
                logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
            }
            Thread.sleep(1000);
        }

        logger.info("Processamento de pagamentos concluído.");

    }
}