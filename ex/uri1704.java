import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Arrays;

public class uri1704
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int N, H;
    static int[] V;
    static HashMap<Integer, Integer> VT;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]);
        V = new int[N];
        VT = new HashMap<Integer, Integer>();

        int v = 0, t = 0;

        for (int n = 0; n < N; ++n)
        {
            line = BR.readLine().split(" ");
            v = Integer.parseInt(line[0]);
            t = Integer.parseInt(line[1]);
            V[n] = v;
            VT.put(v, t);
        }
    }

    static void draw()
    throws IOException
    {
        int h = H;
        int v = 0;
        int t = 0;
        int i = 0;
        int r = 0;

        for (Arrays.sort(V); h > 0 && i < N; ++i)
        {
            v = V[N - i - 1];
            t = VT.get(v);

            if (h - t >= 0)
                h -= t;
            else
                h = 0;
        }

        i++;
        v = V[i];
        t = VT.get(v);
        while (t == H && i < N)
        {
            r += t;
            i++;
            v = V[i];
            t = VT.get(v);
        }

        System.out.println(r);
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        draw();

        while (true)
        {
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
}
