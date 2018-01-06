import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1267 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static int numberAlumni, numberDinner;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String[] line = in.readLine().split(" ");
      numberAlumni = Integer.parseInt(line[0]);
      numberDinner = Integer.parseInt(line[1]);
    }
    catch (Exception NumberFormatException) {
      numberAlumni = numberDinner = 0;
    }

    if (numberAlumni == 0 && numberDinner == 0) flag = false;
    return flag;
  }

  public static void main(String[] args) throws IOException {
    String[] line;
    int[] peopleAtDinner;
    boolean present;

    while (readData()) {
      peopleAtDinner = new int[numberAlumni];

      for (int d = 0; d < numberDinner; ++d) {
        line = in.readLine().split(" ");

        for (int p = 0; p < numberAlumni; ++p)
          peopleAtDinner[p] += Integer.parseInt(line[p]);
      }

      present = false;
      for (int i = 0; i < numberAlumni && !present; ++i)
        if (peopleAtDinner[i] == numberDinner) present = true;

      if (present) System.out.println("yes");
      else System.out.println("no");
    }
  }
}
