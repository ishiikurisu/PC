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
    static int wagon;
    static int numberWagons;

    static private boolean dequeue()
    {
        boolean flag = true;

        if (queueSize < numberWagons) {
            if (queue[queueSize] == wagon) {
                queueSize++;
                wagon--;
            }
            else if (queue[queueSize] > wagon) {
                flag = false;
            }
        }
        else {
            flag = false;
        }

        return flag;
    }

    static private boolean pop()
    {
        boolean flag = true;

        if (stackSize < 0) {
            flag = push();
        }
        else {
            if (stack[stackSize] == wagon) {
                stackSize--;
                wagon--;
            }
            else if (queue[queueSize] > stack[stackSize]) {
                flag = push();
            }
            else {
                flag = false;
            }
        }

        return flag;
    }

    static private boolean push()
    {
        boolean flag = true;

        try {
            stackSize++;
            stack[stackSize] = queue[queueSize];
            queueSize++;
        }
        catch (Exception any) {
            flag = false;
        }

        return flag;
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split("\\s+");
        queue = new int[numberWagons];
        stack = new int[numberWagons];
        queueSize = 0;
        stackSize = -1;
        wagon = numberWagons;

        for (int i = numberWagons-1; i > 0; --i)
            queue[i] = Integer.parseInt(line[i]);
    }

    static void draw()
    throws IOException
    {
        boolean result = true;

        while (wagon < numberWagons && result)
        {
            result &= (dequeue() || pop());
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
            while (true)
            {
                try {
                    setup();
                    draw();
                }
                catch (Exception any) {
                    System.out.println(/*any*/);
                    break;
                }
            }

            numberWagons = Integer.parseInt(BR.readLine());
        }

        BR.close();
        ISR.close();
    }
}
