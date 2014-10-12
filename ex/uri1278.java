import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

public class uri1278 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static List sentences;
  static int numberSentences, biggestSize;
  static int[] sentencesSize;
  static boolean firstSentence = true;

  static boolean readData() throws IOException {
    boolean flag = true;
    numberSentences = Integer.parseInt(in.readLine());
    String[] line;

    if (numberSentences > 0) {
      sentences = new LinkedList<String[]>();

      for (int p = 0; p < numberSentences; ++p) {
        line = in.readLine().split("\\s+");
        sentences.add(line);
      }
    }
    else flag = false;

    return flag;
  }

  static void processData() {
    sentencesSize = new int[numberSentences];
    String[] line;
    int currentSize, p, w;
    biggestSize = 0;

    for (p = 0; p < numberSentences; ++p) {
      line = (String[]) sentences.get(p);
      w = 0;
      currentSize = 0;

      while (true) {
        try {
          currentSize += line[w].length(); }
        catch (Exception ArrayIndexOutOfBoundsException) {
          break; }
        ++currentSize;
        ++w;
      }

      sentencesSize[p] = currentSize;
      if (currentSize > biggestSize)
        biggestSize = currentSize;
    }
  }

  static void writeData() {
    String[] line;
    int p, w;

    if (firstSentence == true) {
      firstSentence = false;
    }
    else {
      System.out.println("\n");
    }

    for (p = 0; p < numberSentences; ++p) {
      line = (String[]) sentences.get(p);

      for (w = 0; w < biggestSize - sentencesSize[p]; ++w) {
        System.out.print(" "); }

      w = 0;
      while (true) {
        try {
          System.out.print(line[w].trim()); }
        catch (Exception ArrayIndexOutOfBoundsException) {
          System.out.println();
          break;
        }
        System.out.print(" ");
        ++w;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
