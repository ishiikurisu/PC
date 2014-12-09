import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;
import java.util.LinkedList;

public class uri1610 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    BitSet path;
    List queue;
    String[] line;
    int dom, sub;
    int doc, fil;
    int docs, rels;
    boolean[][] ships;
    boolean outlet;

    for (int c = 0; c < numberCases; c++) {
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
      for (dom = 0; dom < docs && outlet == false; ++dom) {
        queue = new LinkedList<Integer>();
        path = new BitSet();

        queue.add(dom);
        while (!queue.isEmpty() && outlet == false) {
          dom = (int) queue.remove(0);

          for (sub = 0; sub < docs && outlet == false; ++sub) {
            if (ships[dom][sub] == true && path.get(sub) == false) {
              path.set(sub, true);
              queue.add(sub);
            }
            else if (ships[dom][sub] == true && path.get(sub) == true) {
              outlet = true;
            }
          }
          
        }
      }

      /* write data */
      if (outlet)
        System.out.println("SIM");
      else
        System.out.println("NAO");
    }
  }
}
