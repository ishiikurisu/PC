import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1437
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static int direction;

    public static void main(String[] args)
    throws IOException
    {
        int numberSteps = Integer.parseInt(BR.readLine());

        while (numberSteps > 0)
        {
            setup();
            draw();
            numberSteps = Integer.parseInt(BR.readLine());
        }

        BR.close();
        ISR.close();
    }

    static void setup()
    throws IOException
    {
        String steps = BR.readLine();

        direction = 0;
        for (int i = 0; i < steps.length(); ++i)
            if (steps.charAt(i) == 'D')
                ++direction;
            else
                --direction;
    }

    static void draw()
    throws IOException
    {
        String answer = "N";

        switch (abs(direction % 4))
        {
            case 1: answer = "L"; break;
            case 2: answer = "S"; break;
            case 3: answer = "O"; break;
            default: answer = "N";
        }

        System.out.println(answer);
    }

    static int abs(int n)
    {
        return (n > 0)? n : n + 4;
    }
}
