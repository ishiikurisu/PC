import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;

public class spojNHAY
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static LinkedList<Character> pattern;
    static LinkedList<Character> text;
    static int patternSize;
    static int patternHash;

    public static void main(String[] args)
    throws IOException
    {
        char readChar;

        while (true)
        {
            try {
                setup();
                draw();
            }
            catch (Exception any) {
                System.out.println(any);
                break;
            }
        }

        BR.close();
        ISR.close();
    }

    static void setup()
    throws IOException
    {
        patternSize = Integer.parseInt(BR.readLine());

        pattern = new LinkedList<Character>();
        for (int i = 0; i < patternSize; ++i)
            pattern.add(getchar());
        getchar();

        System.out.println(pattern.toString());
    }

    static void draw()
    throws IOException
    {
        LinkedList<Integer> results = search();

        if (results.size() == 0)
            System.out.println();
        else for (int i = 0; i < results.size(); ++i)
            System.out.println(results.get(i));
    }

    static LinkedList<Integer> search()
    throws IOException
    {
        LinkedList<Integer> outlet = new LinkedList<Integer>();
        char readChar = getchar();
        int position = 0;

        patternHash = pattern.hashCode();
        text = new LinkedList<Character>();

        while (readChar != '\n' && position < patternSize)
        {
            text.add(readChar);
            readChar = getchar();
            position++;
        }

        System.out.println(text.toString());

        while (readChar != '\n')
        {
            if (rabinKarp())
                outlet.add(position - patternSize);
            text.pop();
            text.add(readChar);
            System.out.println(text.toString());

            readChar = getchar();
            position++;
        }

        return outlet;
    }

    static boolean rabinKarp()
    {
        int textHash = text.hashCode();
        boolean result = false;

        if (textHash == patternHash) {
            if (text.equals(pattern))
                result = true;
        }

        return result;
    }

    static char getchar()
    throws IOException
    { return (char) BR.read(); }
}
