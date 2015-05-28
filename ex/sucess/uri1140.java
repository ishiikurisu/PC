import java.util.*;
import java.io.*;

public class uri1140
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static String input;

    static void setup()
    throws IOException
    {
        input = BR.readLine();
        if (input.equals("*"))
            throw new IOException();
    }

    static void draw()
    {
        String[] words = input.split(" ");
        boolean result = true;

        int i = 1;

        while (true)
        {
            try {
                char previous = words[i - 1].toLowerCase().charAt(0);
                char next = words[i].toLowerCase().charAt(0);
                if (previous != next)
                    result = false;
            }
            catch (Exception any) {
                break;
            }
            ++i;
        }

        if (result)
            System.out.println("Y");
        else
            System.out.println("N");
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
