  import java.io.InputStreamReader;
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.util.Collections;
  import java.util.List;
  import java.util.ArrayList;

  public class uri1556 {
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(ir);

    static String inlet;
    static List outlet;

    static boolean readData() throws IOException {
      inlet = in.readLine();
      if (inlet != null) return true;
      else return false;
    }

    static void formWord(String word, int pivotIndex, int wordSize) {
      if (word.length() == wordSize && outlet.indexOf(word) < 0)
          outlet.add(word);
      else for (int i = pivotIndex; i < inlet.length(); ++i) {
        String newWord = word + inlet.charAt(i);
        formWord(newWord, i + 1, wordSize);
      }
    }

    public static final void main(String[] args) throws IOException {
      int wordSize;
      int firstLetter;

      while (readData()) {
        outlet = new ArrayList<String>();

        for (wordSize = 1; wordSize <= inlet.length(); ++wordSize)
          for (firstLetter = 0; firstLetter < inlet.length(); ++firstLetter)
            formWord("", firstLetter, wordSize);

        Collections.sort(outlet);

        for (Object out: outlet)
          System.out.println((String) out);

        System.out.println();
      }
    }
  }
