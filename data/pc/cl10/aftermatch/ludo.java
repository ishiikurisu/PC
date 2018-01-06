import java.util.*;
import java.io.*;

public class ludo {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numeroJogadores, numeroCasas;
  static int numeroLancamentos, vencedor;
  static int[] armadilha, posicao;
  static List[] lancamentos; // change lists to stacks

  static boolean readData() throws IOException {
    List lancamento;
    boolean flag = true;

    try {
      String[] info = in.readLine().split(" ");
      numeroJogadores = Integer.parseInt(info[0]);
      numeroCasas = Integer.parseInt(info[1]);

      posicao = new int[numeroJogadores];
      for (int i = 0; i < numeroJogadores; ++i) posicao[i] = 0;

      info = in.readLine().split(" ");
      armadilha = new int[3];
      for (int i = 0; i < 3; ++i) armadilha[i] = Integer.parseInt(info[i]);

      numeroLancamentos = Integer.parseInt(in.readLine());
      lancamentos = new List[numeroJogadores];
      for (int i = 0; i < numeroLancamentos; ++i)
        lancamentos[i] = new LinkedList<Integer>();

      for (int i = 0; i < numeroLancamentos; ++i) {
        lancamento = lancamentos[i % numeroJogadores];
        info = in.readLine().split(" ");
        lancamento.add(Integer.parseInt(info[0]) + Integer.parseInt(info[1]));
      }
    }
    catch (Exception IOException) {
      numeroJogadores = numeroCasas = 0;
    }

    if (numeroJogadores == 0 || numeroCasas == 0) flag = false;
    return flag;
  }

  static void processData() {
    int jogadorAtual;
    boolean flagArmadilha;
    boolean[] espera = new boolean[numeroJogadores];
    List lancamento;

    // preparando o jogo
    vencedor = -1;
    for (int i = 0; i < numeroJogadores; ++i)
      espera[i] = true;

    // jogando...
    for (int i = 0; i < numeroLancamentos && vencedor < 0; ++i) {
      jogadorAtual = (numeroJogadores + i) % numeroJogadores;

      // o jogador pode jogar?
      while (espera[jogadorAtual] == false) {
        espera[jogadorAtual] = true;
        jogadorAtual++;
        if (jogadorAtual == numeroJogadores) jogadorAtual = 0;
      }

      // movimento do jogador
      lancamento = lancamentos.pop(jogadorAtual);
      posicao[jogadorAtual] += (int) lancamento.get(jogadorAtual);

      // o jogador caiu em uma armadilha?
      flagArmadilha = false;
      for (int a = 0; a < 3; ++a)
        if (posicao[jogadorAtual] == armadilha[a])
          flagArmadilha = true;
      if (flagArmadilha == true)
        espera[jogadorAtual] = false;

      // o jogador chegou ao final do jogo?
      if (posicao[jogadorAtual] == numeroCasas)
        vencedor = jogadorAtual;
    }
  }

  static void writeData() {
    System.out.println(++vencedor);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
