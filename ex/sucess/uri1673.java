import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static String input = null;
    static ArrayList<String> chars = null;
    static ArrayList<Integer> occur = null;

    static void add(String current)
    {
        int len = occur.size() - 1;
        String last = chars.get(len);

        if (current.equals(last))
            occur.set(len, occur.get(len) + 1);
        else {
            chars.add(current);
            occur.add(1);
        }
    }

    static String prepare(String inlet, String parameter)
    {
        String outlet = "";
        String piece = "";
        int c = 0;

        while (true)
        {
            try {
                piece = inlet.substring(c, c + 1);
                if (piece.equals(parameter))
                    outlet += parameter;
                outlet += piece;
            }
            catch (Exception any) {
                break;
            }

            c++;
        }

        return outlet;
    }

    static void simplify()
    {
        ArrayList<String> nc = new ArrayList<String>();
        ArrayList<Integer> nf = new ArrayList<Integer>();
        String temp = "";
        int limit = occur.size();
        int i = 0;
        int d = 0;

        while (i < chars.size())
        {
            temp = "";
            d = 0;

            if (occur.get(i) > 1) {
                temp += chars.get(i);
                nf.add(occur.get(i));
            }
            else {
                while (i + d < limit)
                {
                    if (occur.get(i + d) == 1)
                        temp += chars.get(i + d);
                    else
                        break;
                    ++d;
                }

                nf.add(1);
                i += d - 1;
            }

            nc.add(temp);
            ++i;
        }

        chars = nc;
        occur = nf;
    }

    static void setup()
    throws IOException
    {
        input = BR.readLine();
        chars = new ArrayList<String>();
        occur = new ArrayList<Integer>();

        if (input.length() == 0)
            return;

        int i = 1;
        int added = 0;
        int limit = input.length();

        chars.add(input.substring(0, 1));
        occur.add(1);

        while (i < limit)
        {
            add(input.substring(i, i + 1));
            ++i;
        }

        simplify();
    }

    static void draw()
    {
        String output = "";
        String one = "1";

        if (input.length() != 0)
        while (!occur.isEmpty())
        {
            String current = chars.remove(0);
            int frequency = occur.remove(0);

            if (frequency == 1) {
                output += one + prepare(current, one) + one;
            }
            else {
                if (frequency <= 9)
                    output += frequency + "" + current;
                else {
                    output += "9" + current;
                    frequency -= 9;
                    chars.add(0, current);
                    occur.add(0, frequency);
                    simplify();
                }
            }
        }

        System.out.println(output);
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
