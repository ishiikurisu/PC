import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class uri1739
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static ArrayList<Long> threebonacci;
    final static long limit = 60;
    final static char three = '3';

    public static void main(String[] args)
    throws IOException
    {
        setup();
        while (true)
        {
            try {
                draw();
            }
            catch (Exception any) {
                break;
            }
        }

        BR.close();
        ISR.close();
    }

    static void setup()
    {
        long a = 1;
        long b = 1;
        long c = a + b;

        threebonacci = new ArrayList<Long>();
        while (threebonacci.size() < limit)
        {
            if (c % 3 == 0 || Long.toString(c).indexOf(three) >= 0) {
                threebonacci.add(c);
            }

            a = c;
            c = c + b;
            b = a;
        }
    }

    static void draw()
    throws IOException
    {
        int desiredNumber = Integer.parseInt(BR.readLine());
        System.out.println(threebonacci.get(--desiredNumber));
    }
}
