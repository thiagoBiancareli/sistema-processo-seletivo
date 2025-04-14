import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.SourceDataLine;

public class ProcessoSeletivo {
  public static void main(String[] args) throws Exception {
    String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO" };

    for (String candidato : candidatos) {
      entrandoEmContato(candidato);
    }
  }

  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if (continuarTentando) {
        tentativasRealizadas++;
      } else {
        System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
      }
    } while (continuarTentando && tentativasRealizadas < 3);

    if (atendeu) {
      System.out.println("Contato realizado com sucesso");
    } else
      System.out
          .println("Não conseguimos contato com " + candidato + " número maximo de tentativas " + tentativasRealizadas);
  }

  // método auxilar simular ligação
  static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  static void imprimirSelecionados() {
    String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO" };

    for (String candidato : candidatos) {
      System.out.println("O candidato foi selecionado foi " + candidato);
    }
  }

  static void selecaoCandidatos() {
    String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MILENA", "DANIELA",
        "JORGE" };

    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.0;

    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
      String candidato = candidatos[candidatoAtual];
      Double salarioPretendido = valorPretendido();

      System.out.println("O candidato" + candidato + " solicitou esse valor de salário " + salarioPretendido);
      if (salarioPretendido <= salarioBase) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatoAtual++;
    }
  }

  // método auxiliar para gerarv um valor pretendido
  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void AnalisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato");
    } else if (salarioBase == salarioPretendido) {
      System.out.println("Ligar para o candidato com contra proposta");
    } else {
      System.out.println("Aguardando resultado demais candidatos");
    }
  }
};
