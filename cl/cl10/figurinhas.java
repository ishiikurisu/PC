import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class figurinhas {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int F, J;
  static List FFig;
  static List JFig;
  static int grito = 0;

  static void puts(String input) {
    System.out.println(input);
  }

  static boolean readData() throws IOException {
    String[] info;
    boolean flag = true;
    int temp;

    try {
      info = in.readLine().split(" ");
      F = Integer.parseInt(info[0]);
      J = Integer.parseInt(info[1]);

      if (F != 0 && J != 0) {

        FFig = new LinkedList<Integer>();
        for (int i = 0; i < F; ++i) {
          temp = Integer.parseInt(in.readLine());
          FFig.add(temp);
          //puts(temp + "");
        }

        JFig = new LinkedList<Integer>();
        for (int i = 0; i < J; ++i) {
          temp = Integer.parseInt(in.readLine());
          JFig.add(temp);
          //puts(temp + "");
        }
      }
    }
    catch (Exception NumberFormatException) {
      F = 0; J = 0;
    }

    if (F == 0 && J == 0) flag = false;
    return flag;
  }

  static void processData() {
    boolean flag = false;
    Collections.sort(FFig);


    grito++;
    System.out.println("GRITO #" + grito);
    for (int x = 0; x < J; ++x) {
      for (int y = 0; y < F; ++y) {
        flag = false;

        if (FFig.get(y) == JFig.get(x)) {
          System.out.println(JFig.get(x) + " escalado na posicao " + ++y);
          FFig.set(y, 0);
          System.out.println(FFig.get(y-1));
          flag = true;
          break;
        }
      }

      if (flag == false)
        System.out.println(JFig.get(x) + " nao foi convocado");
    }
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }

}
