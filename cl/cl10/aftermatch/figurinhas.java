import java.util.*;
import java.io.*;

public class figurinhas {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int thor, loki;
  static int grito = 0;
  static List thorCards, lokiCards;
  static Map foundCards;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String[] info = in.readLine().split(" ");
      thor = Integer.parseInt(info[0]);
      loki = Integer.parseInt(info[1]);
      thorCards = new LinkedList<Integer>();
      lokiCards = new LinkedList<Integer>();

      for (int i = 0; i < thor; ++i)
        thorCards.add(Integer.parseInt(in.readLine()));
      for (int i = 0; i < loki; ++i)
        lokiCards.add(Integer.parseInt(in.readLine()));
    }
    catch (Exception NumberFormatException) {
      thor = loki = 0;
    }

    if (thor == 0 || loki == 0) flag = false;
    return flag;
  }

  static void processData() {
    foundCards = new HashMap<Integer, Integer>();

    for (int t = 0; t < thor; ++t)
      for (int l = 0; l < loki; ++l)
        if (thorCards.get(t) == lokiCards.get(l))
          foundCards.put(lokiCards.get(l), t + 1);
  }

  static void writeData() {
    grito++;

    System.out.println("GRITO #" + grito);
    for (int i = 0; i < loki; ++i)
      if (foundCards.???(lokiCards.get(i))) {
        System.out.print(lokiCards.get(i) + " escalado na posicao ");
        System.out.println(foundCards.get(lokiCards.get(i)));
      }
      else
        System.out.println(lokiCards.get(i) + " nao foi convocado");
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
