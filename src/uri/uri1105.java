import java.util.*;
import java.io.*;

public class uri1105 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberBanks, numberDebentures;
  static List reserves, debts;
  static boolean result;

  static boolean readData() throws IOException {
    String[] line;
    boolean flag = true;

    try {
      line = in.readLine().split(" ");
      numberBanks = Integer.parseInt(line[0]);
      numberDebentures = Integer.parseInt(line[1]);

      if (numberBanks > 0 && numberDebentures > 0) {
        reserves = new LinkedList<Integer>();
        debts = new LinkedList<Integer[]>();

        line = in.readLine().split(" ");
        for (int i = 0; i < numberBanks; ++i)
          reserves.add(Integer.parseInt(line[i]));
        for (int i = 0; i < numberDebentures; ++i) {
          line = in.readLine().split(" ");
          int[] contract = new int[3];
          contract[0] = Integer.parseInt(line[0]) - 1;
          contract[1] = Integer.parseInt(line[1]) - 1;
          contract[2] = Integer.parseInt(line[2]);
          debts.add(contract);
        }
      }
    }
    catch (Exception NumberFormatException) {
      numberBanks = numberDebentures = 0;
    }

    if (numberBanks <= 0 && numberDebentures <= 0) flag = false;
    return flag;
  }

  static void processData() {
    int deb, debtor, creditor, money;
    int[] contract;
    result = true;

    for (deb = 0; deb < numberDebentures; ++deb) {
      contract = (int[]) debts.get(deb);
      debtor = contract[0];
      creditor = contract[1];
      money = contract[2];
      reserves.set(debtor, (int) reserves.get(debtor) - money);
      reserves.set(creditor, (int) reserves.get(creditor) + money);
    }

    for (deb = 0; deb < numberBanks && result; ++deb) {
      if ((int) reserves.get(deb) < 0) result = false;
    }
  }

  static void writeData() {
    if (result) System.out.println("S");
    else System.out.println("N");
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
