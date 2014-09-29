import java.util.*;
import java.io.*;

public class uri1110 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static List populateDeck(int size) {
    List sequence = new LinkedList<Integer>();

    for (int n = 1; n <= size; ++n) sequence.add(n);

    return sequence;
  }

  public static void main(String[] args) throws IOException {
    int deckSize, c;
    List deck, discardedCards;

    deckSize = Integer.parseInt(in.readLine());
    while (deckSize > 0) {
      deck = populateDeck(deckSize);
      discardedCards = new LinkedList<Integer>();

      while (deck.size() > 1) {
        discardedCards.add(deck.remove(0));
        deck.add(deck.remove(0));
        --deckSize;
      }

      System.out.print("Discarded cards: ");
      for (c = 0; c < discardedCards.size() - 1; c++)
        System.out.print(discardedCards.get(c) + ", ");
      System.out.println((int) discardedCards.get(c));

      System.out.print("Remaining card: ");
      System.out.println((int) deck.get(0));

      deckSize = Integer.parseInt(in.readLine());
    }
  }

}
