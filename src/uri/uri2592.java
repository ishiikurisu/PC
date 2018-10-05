package uri;

import java.io.*;

public class uri2592 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static int N;
  
  public static int[] readLine() throws IOException {
    String[] line = in.readLine().split(" ");
    int limit = line.length;
    int[] array = new int[limit];
    
    for (int i = 0; i < limit; i++) {
      array[i] = Integer.parseInt(line[i]);
    }
    
    return array;
  }
  
  public static boolean isSorted(int[] array) {
    for (int i = 1; i < N; i++) {
      if (array[i] < array[i-1]) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) throws IOException {
    int[] array = readLine();
    int howManyTries = 0;
    boolean done = false;
    
    N = array[0];
    while (N > 0) {
      array = readLine();
      if (array.length == 1) {
        System.out.println(howManyTries);
        N = array[0];
        howManyTries = 0;
        done = false;
      } else {
        if (!done) {
          howManyTries++;
          done = isSorted(array);
        }
      }
    }
  }
}