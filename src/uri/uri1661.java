import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1661 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);
  static final long UNKNOWN = 0x7FFFFFFF;

  static long population;
  static long[] demand;
  static long workUnits;

  static long min(long a, long b) {
    return (a < b)? a : b;
  }

  static long evaluate(int house, long wine, long units) {
    long best;

    if (house < 0 || house >= population)
      best = UNKNOWN;
    else if (wine == 0)
      best = units;
    else
      best = min(
        evaluate(house+1, wine + demand[house], units + 1),
        evaluate(house-1, wine + demand[house], units + 1)
      );

    return best;
  }

  static void readData() throws IOException {
    population = Integer.parseInt(in.readLine());

    if (population == 0)
      throw new IOException();
    else {
      String[] line = in.readLine().split(" ");
      demand = new long[(int) population];
      for (int i = 0; i < population; ++i)
        demand[i] = Integer.parseInt(line[i]);
    }
  }

  static void processData() {
    long wine;
    workUnits = UNKNOWN;

    for (int p = 0; p < population; ++p) {
      wine = demand[p];
      workUnits = min(workUnits, evaluate(p, wine, 0));
    }
  }

  static void writeData() {
    System.out.println(workUnits);
  }

  public static final void main(String[] args) {
    while (true) {
      try { readData(); }
      catch (Exception any) { break; }
      processData();
      writeData();
    }

    try {
      in.close();
      isr.close();
    }
    catch (IOException ioe) { }
  }
}
