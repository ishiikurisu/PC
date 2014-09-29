import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

public class uri1211 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberPhones;
  static String[] phoneBook;
  static int result;

  static boolean readData() throws IOException {
    try {
      numberPhones = Integer.parseInt(in.readLine());
      phoneBook = new String[numberPhones];
      for (int n = 0; n < numberPhones; ++n) {
        phoneBook[n] = in.readLine();
      }
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    List phoneRelation = new LinkedList<List>();
    List partialRelation = new LinkedList<Integer>();
    List tempRelation;
    String phone;
    result = 0;

    
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
