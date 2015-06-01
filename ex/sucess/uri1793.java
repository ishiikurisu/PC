import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int numberPeople = 100;
    static int stairTime = 10;
    static ArrayList<Integer> peopleTime = null;

    static void setup()
    throws IOException
    {
        String[] line = null;

        numberPeople = Integer.parseInt(BR.readLine());
        if (numberPeople == 0) throw new IOException();

        peopleTime = new ArrayList<Integer>();
        line = BR.readLine().split(" ");
        for (int people = 0; people < numberPeople; ++people)
            peopleTime.add(Integer.parseInt(line[people]));
    }

    static void draw()
    {
        int moment = 0;
        int lastMoment = 0;
        int totalTime = 0;

        lastMoment = peopleTime.remove(0);
        while (!peopleTime.isEmpty())
        {
            moment = peopleTime.remove(0);
            if (moment - lastMoment > stairTime)
                totalTime += stairTime;
            else
                totalTime += moment - lastMoment;
            lastMoment = moment;
        }

        totalTime += stairTime;
        System.out.println(totalTime);
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

        BR.close();
        ISR.close();
    }
}
