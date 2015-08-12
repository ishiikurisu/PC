import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class uri1410
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static int numberAttackers;
    static int numberDefenders;
    static int[] attackers;
    static int[] defenders;

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
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split("\\s+");

        numberAttackers = Integer.parseInt(line[0]);
        numberDefenders = Integer.parseInt(line[1]);
        if (numberAttackers == 0 && numberDefenders == 0)
            throw new IOException();

        attackers = new int[numberAttackers];
        defenders = new int[numberDefenders];

        line = BR.readLine().split("\\s+");
        for (int i = 0; i < numberAttackers; ++i)
            attackers[i] = Integer.parseInt(line[i]);
        line = BR.readLine().split("\\s+");
        for (int i = 0; i < numberDefenders; ++i)
            defenders[i] = Integer.parseInt(line[i]);

        Arrays.sort(attackers);
        Arrays.sort(defenders);
    }

    static void draw()
    throws IOException
    {
        boolean result = false;
        int i = numberAttackers - 1;

        while (!result && i >= 0)
        {
            if (attackers[i] < defenders[1]) {
                result = true;
            }
            else {
                --i;
            }
        }

        String outlet = "N";
        if (result) outlet = "Y";
        System.out.println(outlet);
    }
}
