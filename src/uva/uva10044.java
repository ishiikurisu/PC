import java.util.*;
import java.io.*;

public class uva10044 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberDescriptions, numberAuthors;
  static List descriptions, authors;
  static List authorConnections;

  /* DATA STRUCTURES */
  static void addToGraph(String[] responsible) {
    List connection;
    boolean flag;
    int i;

    for (String currentAuthor: responsible) {
      flag = false;
      i = 0;

      for (i = 0; i < authorConnections.size() && !flag; ++i) {
        connection = (List) authorConnections.get(i);
        if (currentAuthor.equals((String) connection.get(0))) flag = true;
      }

      if (!flag) {
        connection = new LinkedList<String>();
        connection.add(currentAuthor);
      }

      for (String friendAuthor: responsible)
        if (friendAuthor != currentAuthor) connection.add(friendAuthor);
    }

  }

  static List searchForFriend(List list, String friend) {
    List result = null;
    List it;

    for (it: list) {
      if (friend.equals((String) it.get(0))) result = friend;
      if (result != null) break;
    }

    return result;
  }

  /* BUSINESS FUNCTIONS */
  static void populateGraph() {
    String[] partialAuthors;

    for (i = 0; i < numberDescription; ++i) {
      partialAuthors = (descriptions.get(i)).split(":")[0].split(",");
      addToGraph(partialAuthors);
    }
  }

  static void BFSearch() {
    Map erdosNumber = new HashMap<String, Integer>();
    Map authorState;
    List authorFriends;
    List friendsFriends;
    Queue waitingList;
    String friend;

    for (authorFriends: authorConnections) {
      authorState = new HashMap<String, Integer>(); // -1 white, 0 grey, 1 black
      waitingList = new Queue<String>();

      for (int f = 1; f < authorFriends; ++f) {
        String friend = (String) authorFriends.get(i);
        authorState.put(friend, -1);

      }
      friend = authorFriends.get(0);
      authorState.set(friend, 0);
      waitingList.offer(friend);
      while (waitingList.peek() != null) {
        friend = waitingList.poll();
        friendsFriends = searchForFriend(authorConnections, friend);
        for (String friendOfFriend: friendsFriends) {
          if (authorState.get(friendOfFriend) < 0) {
            authorState.remove(friendOfFriend);
            authorState.put(friendOfFriend, 0);
          }
          authorState.remove(friendOfFriend);
          authorState.put(friendOfFriend, 1);
        }
      }
    }

  }

  /* MAIN FUNCTIONS */
  static void readData() throws IOException {
    String[] info;
    int i;

    info = in.readLine().split(" ");
    numberDescriptions = Integer.parseInt(info[0]);
    numberAuthors = Integer.parseInt(info[1]);
    descriptions = new LinkedList<String>();
    authors = new LinkedList<String>();

    for (i = 0; i < numberDescriptions; ++i)
      descriptions.add(in.readLine());
    for (i = 0; i < numberAuthors; ++i)
      authors.add(in.readLine());
  }

  static void processData() {
    authorConnections = new LinkedList<List>();
    Map erdosNumber;

    populateGraph();
    erdosNumber = BFSearch(); // I only needed to do that with Erdos
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      readData();
      processData();
      writeData();
    }
  }
}
