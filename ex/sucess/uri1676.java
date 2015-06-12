import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class uri1676
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static ArrayList<Integer> lucky = new ArrayList<Integer>();

    static void setup()
    throws IOException
    {
        int number = 0;
        int unlucky = 0;
        int removed = 0;
        int first = 0;

        for (number = 2; number <= 40000; number++)
            lucky.add(number);

        first = 0;
        number = lucky.get(first);
        while (number < 35000)
        {
            removed = 0;
            unlucky = 1;

            while (true)
            {
                try {
                    lucky.remove(unlucky * number - removed + first);
                    unlucky++;
                    removed++;
                }
                catch (IndexOutOfBoundsException e1) {
                    break;
                }
            }

            first++;
            number = lucky.get(first);
        }
    }

    static void draw()
    throws IOException
    {
        int input = Integer.parseInt(BR.readLine());

        if (input == 0)
            throw new IOException();
        else
            System.out.println(lucky.get(input - 1));
    }

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
}
