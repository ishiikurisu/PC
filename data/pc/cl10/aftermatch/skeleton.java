import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*USE IT FOR URI PROBLEMS*/

public class Main {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static boolean readData() throws IOException {
    boolean flag = true;

    try {

    }
    catch (Exception NumberFormatException) {

    }

    return flag;
  }

  static void processData() {

  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }

    // Integer.parseInt(in.readLine());
    // System.out.println();
  }

}
