import java.util.*;

public class registrador {
  private static boolean vetor[];
  private static int torneira[];
  private static int estadoInicial;
  private static int estadoFinal;
  private static Scanner input = new Scanner(System.in);

  public static boolean entrada() {
    boolean flag = true;
    int tamanho, torneiras;

    tamanho = input.nextInt();
    torneiras = input.nextInt();
    if (tamanho == torneiras == 0)
      return false;

    vetor = new boolean[tamanho];
    torneira = new int[torneiras];

    for (int i = 0; i < torneiras i++) {
      torneira[i] = input.nextInt();
    }

    estadoInicial = input.nextInt(16);
    estadoFinal = input.nextInt(16);

    return flag;
  }

  public static int possibilidades() {
    String inicio = Integer.toString(estadoInicial, 2);
    String fim = Integer.toString(estadoFinal, 2);
    boolean possible = true;
    boolean resultado;
    int voltas = 0;

    /*parte inicial*/
    for (int i = 0; i < inicio.length(); ++i) {
      if (inicio.charAt(i) == '1')
        vetor[i] = true;
      else
        vetor[i] = false;
    }

    /*algoritmo*/
    // FUCK! WHAT CAN I DO

    return voltas;
  }

  public static final void main(String args[]) {
    boolean key = true;

    key = entrada();
    while (key) {
      System.out.println(possibilidades());
      key = entrada();
    }
  }
}
