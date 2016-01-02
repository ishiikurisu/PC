import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1084 {
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(ir);

    static int numberDigits;
    static int toErase;
    static int[] numbers;
    static int limit;

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
                System.out.println(any);
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

        if (numberDigits == 0) throw new IOException();
        String number = in.readLine();
        numbers = new int[numberDigits];

        for (int c = 0; c < numberDigits; c++)
            numbers[c] = Integer.parseInt(number.charAt(c) + "");
    }

    static void draw()
    throws IOException
    {
        limit = numberDigits - toErase;
        process();
    }

    private static void process()
    {
        int[] result = new int[limit];
        int top = limit-1;
        int temp = top;
        int current = -1;
        int c = 0;

        /* setup result */
        for (c = 0; c < limit; c++)
            result[limit-1-c] = numbers[numberDigits-1-c];

        /* draw result */
        for (c = numberDigits-limit-1; c >= 0; c--)
        {
            current = numbers[c];
            top = 0;

            while (top < limit)
            {
                if (current >= result[top]) {
                    temp = result[top];
                    result[top] = current;
                    current = temp;
                    top++;
                }
                else {
                    top = limit;
                }
            }
        }

        for (c = 0; c < limit; c++)
            System.out.print(result[c]);
        System.out.println();
    }
}
