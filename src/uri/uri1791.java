package uri;

import java.io.*;
import java.util.*;

public class uri1791 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static int C; // number of cases
  static int N; // matrix size
  static int[][] M; // matrix
  
  static void readMatrix() throws IOException {
    M = new int[N][N];
    for (int y = 0; y < N; y++) {
      String[] line = in.readLine().split(" ");
      for (int x = 0; x < N; x++) {
        M[y][x] = Integer.parseInt(line[x]);
      }
    }
  }
  
  static boolean horizontal() {
    int x, y;
    
    for (y = 0; y < N; y++) {
      int[] line = new int[N];
      for (x = 0; x < N; x++) { line[x] = M[y][x]; }
      Arrays.sort(line);
      int m = line[0];
      if (m == 1) {
        m = line[1];
      }
      for (x = 2; x < N; x++) {
        if (Math.pow(m, x) != line[x]) {
          return false; 
        }
      }
    }
    
    return true;
  }
  
  static boolean vertical() {
    int x, y;
    
    for (x = 0; x < N; x++) {
      int[] line = new int[N];
      for (y = 0; y < N; y++) { line[y] = M[y][x]; }
      Arrays.sort(line);
      if (line[0] != 1 && line[1] != 1) { return false; }
      int m = line[0];
      if (m == 1) {
        m = line[1];
      }
      for (y = 2; y < N; y++) {
        if (Math.pow(m, y) != line[y]) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) throws IOException {
    C = Integer.parseInt(in.readLine());
    for (int c = 0; c < C; c++) {
      N = Integer.parseInt(in.readLine());
      readMatrix();
      boolean ok = horizontal() || vertical();
      if (ok) {
        System.out.println("Potencia");
      } else {
        System.out.println("Nao Potencia");
      }
    }
  }
}