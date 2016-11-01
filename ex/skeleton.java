import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*USE IT FOR URI PROBLEMS*/

public class skeleton {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static void readData() throws IOException {
    String[] line = in.readLine().split(" ");
  }

  static void processData() {

  }

  static void writeData() {

  }

  public static void main(String[] args) {
    while (true) {
      try {
        readData();
        processData();
        writeData();
      } catch (Exception any) { }
    }

    try {
      in.close();
      isr.close();
    } catch (IOException ioe) { }
  }

}
