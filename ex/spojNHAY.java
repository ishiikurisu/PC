import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class spojNHAY
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static String pattern;
    static String text;
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
                break;
            }
        }
    }

    static void setup()
    throws IOException
    {
        patternSize = Integer.parseInt(BR.readLine());
        pattern = BR.readLine();
    }

    static void draw()
    throws IOException
    {
        ArrayList<Integer> results = search();

        if (results.size() == 0)
            System.out.println();
        else for (int i = 0; i < results.size(); ++i)
            System.out.println(results.get(i));
    }

    static ArrayList<Integer> search()
    throws IOException
    {
        ArrayList<Integer> outlet = new ArrayList<Integer>();
        char readChar = (char) BR.read();
        int position = 0;

        patternHash = pattern.hashCode();
        text = "";

        while (readChar != '\n' && text.length() < patternSize)
        {
            text += readChar;
            readChar = (char) BR.read();
            position++;
        }

        while (readChar != '\n')
        {
            if (rabinKarp())
                outlet.add(position - patternSize);
            text = text.substring(1) + readChar;

            readChar = (char) BR.read();
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
}
