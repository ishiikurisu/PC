import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class uri1110 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static ArrayList<Integer> populateDeck(int size) {
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    for (int n = 1; n <= size; ++n) sequence.add(n);
    return sequence;
  }

  public static void main(String[] args) throws IOException {
    int deckSize, c;
    ArrayList<Integer> deck;

    deckSize = Integer.parseInt(in.readLine());
    while (deckSize > 0) {
      deck = populateDeck(deckSize);

      System.out.print("Discarded cards: ");
      while (deck.size() > 2) {
        System.out.print(deck.remove(0) + ", ");
        deck.add(deck.remove(0));
      }
      if (deck.size() > 1)
        System.out.println(deck.remove(0));
      else
        System.out.println();

      System.out.print("Remaining card: ");
      System.out.println(deck.remove(0));

      deckSize = Integer.parseInt(in.readLine());
    }

    in.close();
    ir.close();
  }

}
