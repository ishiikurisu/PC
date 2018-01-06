import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class uva573
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static double height;
    static double slideUp;
    static double slideDown;
    static double fatigue;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");

        height = Double.parseDouble(line[0]);
        slideUp = Double.parseDouble(line[1]);
        slideDown = Double.parseDouble(line[2]);
        fatigue = Double.parseDouble(line[3]) / 100.0;

        if (height == 0.0)
            throw new IOException();

        fatigue *= slideUp;
    }

    static void draw()
    {
        int day = 0;
        double distance = 0.0;

        while (distance <= height && distance >= 0)
        {
            day++;
            distance += slideUp;
            if (distance <= height)
                distance -= slideDown;

            slideUp -= fatigue;
            if (slideUp <= 0.0)
                slideUp = fatigue = 0;
        }

        if (distance >= height)
            System.out.println("sucess on day " + day);
        else
            System.out.println("failure on day " + day);
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
    }
}
