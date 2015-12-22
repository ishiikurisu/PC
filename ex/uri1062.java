import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class uri1062
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static int[] queue;
    static int[] stack;
    static int stackSize;
    static int queueSize;
    static boolean result;
    static int numberWagons;

    static private void dequeue()
    {
        
    }

    static private void pop()
    {

    }

    static private void push()
    {

    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split("\\s+");
        queue = new int[numberWagons];
        stack = new int[numberWagons];
        stackSize = queueSize = 0;
        result = true;

        for (int i = 0; i < numberWagons; ++i)
            queue[i] = Integer.parseInt(line[i]);
    }

    static void draw()
    throws IOException
    {
        while (wagon < numberWagons && result)
        {
            dequeue();
            pop();
            push()
        }

        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args)
    throws IOException
    {
        numberWagons = Integer.parseInt(BR.readLine());

        while (numberWagons != 0)
        {
            try {
                setup();
                draw();
            }
            catch (Exception any) {
                System.out.println();
            }

            numberWagons = Integer.parseInt(BR.readLine());
        }

        BR.close();
        ISR.close();
    }
}
