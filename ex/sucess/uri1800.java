import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static TreeSet<Integer> offices = null;
    static int weekOffices = 0;
    static int dayOffices = 0;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        weekOffices = Integer.parseInt(line[0]);
        dayOffices = Integer.parseInt(line[1]);
        offices = new TreeSet<Integer>();

        line = BR.readLine().split(" ");
        for (int o = 0; o < dayOffices; o++)
            offices.add(Integer.parseInt(line[o]));
    }

    static void loop()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int office = Integer.parseInt(line[0]);
        int result = 1;

        if (offices.contains(office))
            result = 0;
        else
            offices.add(office);

        System.out.println(result);
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        for (int c = 0; c < weekOffices; c++)
            loop();

        BR.close();
        ISR.close();
    }
}
