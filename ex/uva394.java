import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class uva394 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberArrays;
  static int numberAcesses;
  static Map arrays;
  static Map arraysMemory;
  static List acesses;
  static List acessesMemory;

  static void readData() throws IOException {
    boolean flag = true;
    List tempList;
    int a, i, m;
    String[] line;

    line = in.readLine().split(" ");
    numberArrays = Integer.parseInt(line[0]);
    numberAcesses = Integer.parseInt(line[1]);
    arrays = new HashMap<String, List>();
    arraysMemory = new HashMap<String, Integer>();
    acesses = new ArrayList<String>();
    acessesMemory = new ArrayList<List>();

    for (int a = 0; a < numberArrays; ++a) {
      line = in.readLine().split(" ");
      tempList = new ArrayList<Integer>();

      int i = 2;
      flag = true;
      while (flag == true) {
        try {
          tempList.add(Integer.parseInt(line[i]));
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
          flag = false;
        }
        ++i;
      }

      arrays.put(line[0], tempList);
      arraysMemory.put(line[0], Integer.parseInt(line[1]));
    }

    for (int m = 0; m < numberAcesses; ++m) {
      line = in.readLine().split(" ");
      tempList = new ArrayList<Integer>();
      acesses.add(line[0]);

      i = 1;
      flag = true;
      while (flag == true) {
        try {
          tempList.add(Integer.parseInt(line[i]));
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
          flag = false;
        }
        ++i;
      }
      acessesMemory.add(tempList);
    }

  }

  static void processData() {
    List currentAcesses;
    String referenceArray;
    List array;
    int arrayMemory;
    int sum;

    for (int a = 0; a < numberAcesses; ++a) {
      /* preparing variables */
      referenceArray = (String) acesses.get(a);
      currentAcesses = (List) acessesMemory.get(a);
      array = (List) arrays.get(referenceArray);
      arrayMemory = (int) arraysMemory.get(referenceArray);
      sum = 0;

      /* aplying formula */

    }
  }

  static void writeData() {
    
  }

  public static final void main(String[] args) throws IOException {
    readData();
    processData();
    writeData();
  }
}
