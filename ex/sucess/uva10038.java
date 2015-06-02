import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class uva10038
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int[] sequence;
    static TreeSet<Integer> gaps;
    static int numberElements;

    static int abs(int a)
    { return (a > 0)? a : -a; }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int last, current;

        numberElements = Integer.parseInt(line[0]);
        sequence = new int[numberElements];
        gaps = new TreeSet<Integer>();

        if (numberElements == 1)
            return;

        last = Integer.parseInt(line[1]);
        sequence[0] = last;
        for (int i = 2; i <= numberElements; ++i)
        {
            current = Integer.parseInt(line[i]);
            sequence[i - 1] = current;
            gaps.add(abs(current - last));
            last = current;
        }
    }

    static void draw()
    {
        String result = "Jolly";
        boolean flag = true;

        if (numberElements == 1)
            flag = true;
        else for (int n = 1; n < numberElements && flag == true; ++n)
            if (!gaps.contains(n))
                flag = false;

        if (flag == false)
            result = "Not jolly";

        System.out.println(result);
    }

    public static void main(String[] args)
    throws IOException
    {
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
