import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.ArrayList;

public class uri1424
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static HashMap<Integer, ArrayList> memo;
    static int n, m;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        memo = new HashMap<Integer, ArrayList>();
        line = BR.readLine().split(" ");
        for (int i = 0; i < n; ++i)
        {
            int item = Integer.parseInt(line[i]);

            if (!memo.containsKey(item))
                memo.put(item, new ArrayList<Integer>());

            memo.get(item).add(i);
        }
    }

    static void draw()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int v = Integer.parseInt(line[1]);
        int result = 0;

        if (memo.containsKey(v))
            try { result = (int) memo.get(v).get(k - 1) + 1; }
            catch (Exception any) { }

        System.out.println(result);
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        for (int i = 0; i < m; ++i)
            draw();

        BR.close();
        ISR.close();
    }
}
