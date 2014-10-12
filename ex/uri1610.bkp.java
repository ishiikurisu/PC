import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class uri1610 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    List path;
    String[] line;
    long past, future;
    int dom, sub;
    int doc, fil;
    int docs, rels;
    boolean[][] ships;
    boolean outlet;

    for (int c = 0; c < numberCases; c++) {
      past = System.nanoTime();

      /* read data */
      line = in.readLine().split(" ");
      docs = Integer.parseInt(line[0]);
      rels = Integer.parseInt(line[1]);
      ships = new boolean[docs][docs];

      for (int r = 0; r < rels; ++r) {
        line = in.readLine().split(" ");
        dom = Integer.parseInt(line[0]) - 1;
        sub = Integer.parseInt(line[1]) - 1;
        ships[dom][sub] = true;
      }

      /* process data */
      outlet = false;
      for (doc = 0; doc < docs && !outlet; ++doc) {
        path = new ArrayList<Integer>();
        for (fil = 0; fil < docs; ++fil)
          if (ships[doc][fil] == true) path.add(fil);
        for (int i = 0; i < path.size(); ++i) {
          dom = (int) path.get(i);
          for (sub = 0; sub < docs; ++sub)
            if (ships[dom][sub] == true && path.indexOf(sub) < 0)
              path.add(sub);
        }
        if (path.indexOf(doc) >= 0) outlet = true;
      }

      /* write data */
      if (outlet)
        System.out.println("SIM");
      else
        System.out.println("NAO");

      future = System.nanoTime();
      System.out.printf("  %.2fms\n", (future-past)/1000000.0);
    }
  }
}
