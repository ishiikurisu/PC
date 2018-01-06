import java.util.*;
import java.io.*;

public class ludo {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int qtd; // numero de jogadores
  static int tam; // tamanho da trilha
  static int num; // numero de jogadas
  static List arm; // armadilhas
  static int[][] jog; // jogadas
  static int[] kkk;

  static List espera;
  static int jogador = 1;

  static void alert() {System.out.println("ASDF");}

  static boolean readData() throws IOException {
    boolean flag = true;
    String[] info;
    espera = new LinkedList<Integer>();
    

    try {
      String line = in.readLine();
      info = line.split(" ");
      qtd = Integer.parseInt(info[0]);
      tam = Integer.parseInt(info[1]);

      if (qtd != 0 && tam != 0) {
        kkk = new int[qtd+1];
        arm = new LinkedList<Integer>();

        String lol = in.readLine();
        info = lol.split(" ");

        for (int i = 0; i < 3; ++i)
          arm.add(Integer.parseInt(info[i]));
        num = Integer.parseInt(in.readLine());

        jog = new int[num][qtd];
        for (int i = 0; i < num; ++i) {
          line = in.readLine();
          info = line.split(" ");
          int sum = 0;

          for (int j = 0; j < qtd; ++j) {
            sum += jog[i][j] = Integer.parseInt(info[j]);
          }

          if (espera.contains(jogador)) {
            espera.remove(jogador);
            jogador++;
            if (jogador > qtd) jogador = 1;
          }
          else {
            kkk[jogador] += sum;
            if (kkk[jogador] > tam) {
              System.out.println(jogador);
              break;
            }
            if (arm.contains(kkk[jogador])) {
              espera.add(jogador);
            }
            jogador++;
            if (jogador > qtd) jogador = 1;
          }


        }
      }
    }
    catch (Exception NumberFormatException) {
      qtd = tam = 0;
    }

    if (qtd == 0 && tam == 0) flag = false;
    return flag;
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {}
  }

}
