import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class uri1042
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int[] integer(String[] input)
    {
        int[] output = new int[3];

        for (int i = 0; i < 3; ++i)
            output[i] = Integer.parseInt(input[i]);

        return output;
    }

    public static void main(String[] args)
    throws IOException
    {
        String[] line  = BR.readLine().split(" ");
        int[] unsorted = integer(line);
        int[] sorted   = Arrays.copyOf(unsorted, 3);

        Arrays.sort(sorted);
        for (int i = 0; i < 3; ++i)
            System.out.println(sorted[i]);
        System.out.println("");
        for (int j = 0; j < 3; ++j)
            System.out.println(unsorted[j]);

        BR.close();
        ISR.close();
    }
}
