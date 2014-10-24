import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class uva101 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static List piles;
  static int numberPiles;

  static List initializePiles(int number) {
    List list = new ArrayList<List>();
    List tempList;

    for (int i = 0; i < number; ++i) {
      tempList = new ArrayList<Integer>();
      tempList.add(i+1);
      list.add(tempList);
    }

    return list;
  }

  static String readData() throws IOException {
    String line = in.readLine();

    if (line.equals("quit")) return null;
    else return line;
  }

  static void processData(String action) {
    String[] line = action.split(" ");
    int origin = Integer.parseInt(line[1]);
    int destiny = Integer.parseInt(line[3]);
    List block;

    if (line[0].equals("move")) {
      if (line[2].equals("onto")) {
        // pile origin block on original position
        // pile destiny block instead
        block = find(origin);

      }
      else {
        // pile destiny block on original position

      }
    }
    else {
      if (line[2].equals("onto"))
    }
  }

  static void writeData() {

  }

  public static final void main(String[] args) throws IOException {
    numberPiles = Integer.parseInt(in.readLine());
    piles = initializePiles(numberPiles);
    String action;

    while ((action = readData()) != null) {
      processData(action);
    }
    writeData();
  }
}
