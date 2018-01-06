import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class uri1615 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int findOutWinner(int[] array, int arraySize) {
    int key = 0;
    int value = 0;

    for (int i = 0; i < arraySize; ++i)
      if (array[i] > value) {
        key = i;
        value = array[i];
      }

    return key;
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    int numberCandidates, numberVotes, winner;
    int[] votes;
    String[] line;

    for (int i = 0; i < numberCases; ++i) {
      line = in.readLine().split(" ");
      numberCandidates = Integer.parseInt(line[0]);
      numberVotes = Integer.parseInt(line[1]);
      votes = new int[numberCandidates];
      line = in.readLine().split(" ");

      for (int vote = 0; vote < numberVotes; ++vote)
        votes[Integer.parseInt(line[vote])-1]++;
      winner = findOutWinner(votes, numberCandidates);
      if ((votes[winner]*100.0)/numberVotes > 50)
        System.out.println(++winner);
      else
        System.out.println("-1");
    }
  }
}
