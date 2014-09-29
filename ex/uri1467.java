import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1467 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static boolean[] ABC;
  static char result;

  static boolean readData() throws IOException {
    String[] line;
    boolean flag = true;

    try {
      line = in.readLine().split(" ");
      for (int i = 0; i < 3; ++i)
        if (Integer.parseInt(line[i]) == 1) ABC[i] = true;
        else ABC[i] = false;
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    int cunt = 0;
    int different = 3;

    for (int i = 0; i < 3; ++i)
      if (ABC[i] == true) cunt++;
      else cunt--;

    if (cunt == 3 || cunt == -3) result = '*';
    else {
      for (int i = 0; i < 3; ++i) {
        if (cunt < 0 && ABC[i] == true) different = i;
        if (cunt > 0 && ABC[i] == false) different = i;
      }
      switch (different) {
        case 0: result = 'A'; break;
        case 1: result = 'B'; break;
        case 2: result = 'C'; break;
      }
    }

  }

  static void writeData() {
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
