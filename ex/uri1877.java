import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1877
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static int numberTowers, numberTops;
    static int[] towers;

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

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split("\\s+");
        numberTowers = Integer.parseInt(line[0]);
        numberTops = Integer.parseInt(line[1]);
        towers = new int[numberTowers];
        line = BR.readLine().split("\\s+");
        for (int i = 0; i < numberTowers; ++i)
            towers[i] = Integer.parseInt(line[i]);
    }

    static void draw()
    throws IOException
    {
        boolean result = false;

        for (int i = 0; i < numberTowers - numberTops && !result; ++i)
        {
            boolean
        }

        System.out.println((result)? "beautiful" : "ugly")
    }
}
