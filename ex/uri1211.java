import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

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
    Set phones = new TreeSet<Integer>();
    String phone;
    result = 0;

    for (int p = 0; p < numberPhones; ++p) {
      
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
