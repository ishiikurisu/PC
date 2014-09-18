import java.util.*;

public class botas {
  private static Scanner input = new Scanner(System.in);
  private static int tamanhoSapato[];
  private static boolean peSapato[];

  public static int possibilidades(int tamanho) {
    int noSapatos = 0;

    for (int i = 0; i < tamanho-1; i++) {
      for (int j = i + 1; j < tamanho; j++) {
        if (tamanhoSapato[i] == tamanhoSapato[j] && peSapato[i] != peSapato[j]) {
          noSapatos++;
        }
      }
    }

    return noSapatos;
  }

  public static int entrada() {
    int tamanho = input.nextInt();

    if (tamanho == 0)
      return tamanho;

    tamanhoSapato = new int[tamanho];
    peSapato = new boolean[tamanho];
    for (int i = 0; i < tamanho; i++) {
      tamanhoSapato[i] = input.nextInt();
      if (input.next().equals("D"))
        peSapato[i] = true;
      else
        peSapato[i] = false;
    }

    return tamanho;
  }

  public static void main(String args[]) {
    int noSapatos;

    noSapatos = entrada();
    while (noSapatos != 0) {
      System.out.println(possibilidades(noSapatos));
      noSapatos = entrada();
    }
  }
}
