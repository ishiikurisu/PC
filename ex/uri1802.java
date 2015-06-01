import java.util.*;
import java.io.*;

public class uri1802
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(BR);

    static int[][] books = null;
    static int bookTypes = 0;
    static int product = 1;

    static int[] read()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int[] array = new int[N];

        for (int i = 0; i < N; ++i)
            array[i] = Integer.parseInt(line[i+1]);

        return array;
    }

    static void setup()
    throws IOException
    {
        books = new int[5][]
        for (int b = 0; b < 5; ++b)
            books[i] = read();
        bookTypes = Integer.parseInt(BR.readLine());
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        draw();
        BR.close();
        ISR.close();
    }
}
