import java.util.*;
import java.io.*;

public class uri1548 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int number;
  static int students;
  static int count;
  static int[] grade;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      number = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      number = 0;
    }

    if (number == 0) flag = false;
    else {
      for (int i = 0; i < number; ++i) {
        students = Integer.parseInt(in.readLine());
        grade = new int[students];

        String[] grades = in.readLine().split(" ");
        for (int j = 0; j < students; ++j)
          grade[j] = Integer.parseInt(grades[j]);

        processData();
        writeData();
      }
    }

    return flag;
  }

  static void processData() {
    Map combination = new HashMap<Integer, Integer>();
    int[] unsorted = new int[students];
    count = 0;

    // copying arrays
    for (int i = 0; i < students; ++i)
      unsorted[i] = grade[i];

    // sort grade array
    Arrays.sort(grade);

    // comparing array
    for (int i = 0; i < students; ++i) {
      //System.out.println(unsorted[i] + " " + grade[students-(1+i)]);
      if (unsorted[i] != grade[students-(1+i)]) {
        if
        (
          combination.get(unsorted[i]) != grade[students-(1+i)] ||
          combination.get(grade[students-(1+i)]) != unsorted[i]
        )
          count++;
        else {
          combination.put(unsorted[i], grade[students-(1+i)]);
          combination.put(grade[students-(1+i)], unsorted[i]);
        }
        //System.out.println(count);
      }
    }
  }

  static void writeData() {
    System.out.println(students - count);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {}
  }

}
