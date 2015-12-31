import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1084 {
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(ir);

    static int numberDigits;
    static int toErase;
    static int[] numbers;

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

        in.close();
        ir.close();
    }

    static void setup()
    throws IOException
    {
        String[] line = in.readLine().split("\\s+");
        numberDigits = Integer.parseInt(line[0]);
        toErase = Integer.parseInt(line[1]);

        if (numberDigits == 0)
            throw new IOException();
        else {
            String number = in.readLine();
            numbers = new int[numberDigits];

            for (int c = 0; c < numberDigits; c++)
                numbers[c] = Integer.parseInt(number.charAt(c) + "");
        }
    }

    static void draw()
    throws IOException
    {
        int[] queue = newQueue();
        int queueSize = -1;
        int lastAdded = -1;

        for (int c = 0; c < numberDigits; c++)
        {
            int digit = numbers[c];

            if (queueSize < 0) {
                queue[0] = digit;
                queueSize++;
                lastAdded = c;
                continue;
            }

            while (queue[queueSize] < digit && queueSize > lastAdded)
            {
                queue[queueSize] = -1;
                queueSize--;
            }

            queue[queueSize] = digit;
            lastAdded = queueSize;
        }

        for (int i = 0; i < queue.length; ++i)
            System.out.print(queue[i]);
        System.out.println();
    }

    private static int[] newQueue()
    {
        int limit = numberDigits - toErase;
        int[] pile = new int[limit];

        for (int n = 0; n < limit; ++n)
            pile[n] = -1;

        return pile;
    }
}
