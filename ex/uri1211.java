import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class uri1211 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberPhones;
  static List phoneBook;
  static int result;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberPhones = Integer.parseInt(in.readLine());
      phoneBook = new ArrayList<String>();
      for (int n = 0; n < numberPhones; ++n) {
        phoneBook.add(in.readLine());
      }
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    int standardSize = ((String) phoneBook.get(0)).length();
    int numberLetters = numberPhones * standardSize;
    int differentLetters = 0;
    result = 0;

    List[] bookEntries = new List[standardSize];
    String phone;
    int number;

    for (int p = 0; p < numberPhones; ++p) {
      phone = (String) phoneBook.get(p);
      for (int n = 0; n < standardSize; ++n) {
        number = Integer.parseInt(phone.substring(n, n+1));
        if (bookEntries[n] == null) {
          bookEntries[n] = new ArrayList<Integer>();
          bookEntries[n].add(number);
        }
        else if (!bookEntries[n].contains(number)) {
          bookEntries[n].add(number);
          n = standardSize;
        }
        else
          differentLetters++;
      }
    }

    //result = numberLetters - differentLetters;
    result = differentLetters;
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
