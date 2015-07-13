import java.util.*;
import java.lang.*;
import java.io.*;

public class uri1313 {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(isr);

    static TreeSet<String> portugues;
    static TreeSet<String> espanol;

    static TreeSet<String> combinations(String s1, String s2) {
        TreeSet<String> partial = new TreeSet<String>();
        String temp;
        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = l1; i > 0; --i) {
            for (int j = 0; j < l2; ++j)  {
                temp = s1.substring(0, i) + s2.substring(j, l2);
                partial.add(temp);
            }
        }

        return partial;
    }

    static void setup() throws IOException {
        String[] inlet = in.readLine().split(" ");
        int pt = Integer.parseInt(inlet[0]);
        int es = Integer.parseInt(inlet[1]);
        int pe = 0;

        if (pt == 0 || es == 0)
            throw new IOException();

        portugues = new TreeSet<String>();
        espanol = new TreeSet<String>();
        for (pe = 0; pe < pt; pe++)
            portugues.add(in.readLine());
        for (pe = 0; pe < es; pe++)
            espanol.add(in.readLine());
    }

    static void draw() {
        TreeSet<String> portunhol = new TreeSet<String>();
        TreeSet<String> temporario;
        int p, s;

        for (String palavra: portugues) {
            for (String palabra: espanol) {
                temporario = combinations(palavra, palabra);
                for (String temporaria: temporario) {
                    portunhol.add(temporaria);
                }
            }
        }

        System.out.println(portunhol.size());
    }

    public static void main (String[] args) throws IOException {
        while (true) {
            try {
                setup();
                draw();
            }
            catch (Exception any) {
                break;
            }
        }
        in.close();
        isr.close();
    }
}
