import java.io.*;
import java.util.*;

public class uri1471 {
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static BitSet swimmers = null;
    static int gone = 0;

    public static void main(String[] args)
    throws IOException {
        while (true) {
            try {
                setup();
                draw();
            }
            catch (Exception any) {
                break;
            }
        }

        BR.close();
        ISR.close();
    }

    public static void setup()
    throws IOException {
        String[] line = BR.readLine().split("\\s+");
        gone = Integer.parseInt(line[0]);
        int back = Integer.parseInt(line[1]);

        if (gone == back) {
            swimmers = null;
        }
        else {
            swimmers = new BitSet();
            line = BR.readLine().split("\\s+");
            for (int i = 0; i < back; ++i) {
                swimmers.set(Integer.parseInt(line[i])-1);
            }
        }
    }

    public static void draw() {
        String outlet = "*";

        if (swimmers != null) {
            outlet = "";
            for (int i = 0; i < gone; ++i)
                if (!swimmers.get(i))
                    outlet += (i+1) + " ";
        }

        System.out.println(outlet);
    }
}
