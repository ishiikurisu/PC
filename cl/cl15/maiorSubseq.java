import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
* Descobrir a maior subsequência crescente dentro de uma sequência
*/
class maiorSubseq {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static int[] inlet;
  static int[] outlet;

  static int max(int a, int b) {
    return (a > b)? a : b;
  }

  static void readData() throws IOException {
    String[] line = in.readLine().split(" ");

    if (line.length() == 1)
      throw new IOException();

    inlet = new int[line.length()];
    for (int i = 0; i < line.length(); ++i)
      inlet[i] = Integer.parseInt(line[i]);
  }

  static void processData() {
    List outlist = new ArrayList<Integer>();
    int inletSize = inlet.length();
    int i, j;

    for (i = 0; i < inletSize; ++i) {
      for (j = 0; j < i; ++j) {
        /* insira programação dinâmica aqui */
      }
    }

    outlet = outlist.toArray(new int[outlist.size()]);
  }

  static void writeData() {
    System.out.print(outlet[0])
    for (int i = 1; i < outlet.length(); ++i) {
      System.out.print(" " + outlet[i]);
    }

    System.out.println();
  }

  public static void main(String[] args) {
    while (true) {
      try {
        readData();
        processData();
        writeData();
      }
      catch (Exception any) {
        break;
      }
    }
  }
}
