import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1245 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberBoots;
  static int[] bootSize;
  static boolean[] bootFoot;

  static boolean readData() throws IOException {
    boolean flag = true;
    String[] line;

    try {
      numberBoots = Integer.parseInt(in.readLine());
      bootSize = new int[numberBoots];
      bootFoot = new boolean[numberBoots];

      for (int b = 0; b < numberBoots; ++b) {
        line = in.readLine().split(" ");
        bootSize[b] = Integer.parseInt(line[0]);
        if (line[1].equals("D"))
          bootFoot[b] = true;
        else
          bootFoot[b] = false;
      }
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  public static final void main(String[] args) throws IOException {
    boolean flag;
    int combinedFeet;

    while (readData())
    {
      combinedFeet = 0;
      for (int b = 0; b < numberBoots - 1; ++b) {
        flag = false;
        for (int f = b; !flag && f < numberBoots; ++f) {
          if (bootSize[b] == bootSize[f] && bootFoot[b] != bootFoot[f]) {
            bootSize[f] = -1;
            bootFoot[f] = false;
            flag = true;
            ++combinedFeet;
          }
        }
      }
      System.out.println(combinedFeet);
    }
  }
}
