import java.io.*;
import java.util.*;

public class uri1814 {
  static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, X, H = 0;
  
  public static void main(String[] args) throws IOException {
    while (true) {
      try { setup(); draw(); } 
      catch (Exception any) { break; }
    }
    BR.close();
  }
  
  public static void setup() throws IOException {
    String[] line = BR.readLine().split("\\s+");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    X = 0;
    
    if (N == 0) throw new IOException();
    ArrayList<String> stuff = new ArrayList<>();
    stuff.add(BR.readLine());
    for (int i = 1; i < N; ++i) {
      String box = BR.readLine();
      int current = M;
      for (String it: stuff)
        current = min(current, distance(box, it));
      stuff.add(box);
      X += current;
    }
  }
  
  public static void draw() {
    System.out.println("Instancia " + (++H));
    System.out.println("" + X);
    System.out.println();
  }
  
  private static int min(int x, int y) {
    return (x < y)? x : y;
  }
  
  private static int distance(String s, String t) {
    int c = 0;
    for (int i = 0; i < M; ++i)
      if (s.charAt(i) != t.charAt(i)) c++;
    return c;
  }
}