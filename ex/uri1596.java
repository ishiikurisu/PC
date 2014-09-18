import java.util.*;
import java.io.*;

public class uri1596 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberPlayers;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberPlayers = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      numberPlayers = 0;
    }

    if (numberPlayers == 0)
      flag = false;
    else {
      
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
  }

}
