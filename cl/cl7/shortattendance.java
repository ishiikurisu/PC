import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class shortattendance {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCases;
  static int numberStudents;
  static String[] students;
  static String[] presence;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
      if (numberCases > 0) for (int T = 0; T < numberCases; ++T) {
        numberStudents = Integer.parseInt(in.readLine());
        students = (in.readLine()).split(" ");
        presence = (in.readLine()).split(" ");
        processData();
      }
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    List disapprovedStudents = new LinkedList();
    int numberOfPresences, numberOfClasses;
    double np, nc;
    double percentual;

    for (int i = 0; i < numberStudents; ++i) {
      numberOfPresences = numberOfClasses = 0;
      for (int j = 0; j < presence[i].length(); ++j) {
        switch (presence[i].charAt(j)) {
          case 'M':
            break;
          case 'P':
            numberOfPresences++;
          case 'A':
            numberOfClasses++;
        }
      }
      np = numberOfPresences;
      nc = numberOfClasses;
      percentual = np / nc;
      if (percentual < 0.75) {
        disapprovedStudents.add(students[i]);
      }
    }

    writeData(disapprovedStudents);
  }

  static void writeData(List students) {
    for (int i = 0; i < students.size(); ++i) {
      System.out.print(students.get(i) + " ");
    }
    System.out.print("\n");
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {}
  }

}
