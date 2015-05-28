import java.util.*;
import java.io.*;

public class uri1523
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int numberDrivers;
    static int parkingLotSize;
    static HashMap<Integer, Integer> arrival;
    static HashMap<Integer, Integer> departure;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        numberDrivers = Integer.parseInt(line[0]);
        parkingLotSize = Integer.parseInt(line[1]);

        if (numberDrivers == 0 && parkingLotSize == 0)
            throw new IOException();
        arrival = new HashMap<Integer, Integer>();
        departure = new HashMap<Integer, Integer>();
        for (int i = 0; i < numberDrivers; ++i)
        {
            line = BR.readLine().split(" ");
            arrival.put(Integer.parseInt(line[0]), i);
            departure.put(Integer.parseInt(line[1]), i);
        }
    }

    static void draw()
    {
        ArrayList<Integer> parkingLot = new ArrayList<Integer>();
        String result = "Sim";
        boolean flag = true;
        int added = 0;
        int moment = 0;
        int driver = 0;
        int waiter = 0;

        while (flag && !departure.isEmpty())
        {
            if (arrival.containsKey(moment)) {
                driver = arrival.get(moment);
                parkingLot.add(0, driver);
                ++added;
            }
            else if (departure.containsKey(moment)) {
                driver = departure.get(moment);
                if (driver == parkingLot.get(0)) {
                    departure.remove(moment);
                    parkingLot.remove(0);
                    --added;
                }
                else flag = false;
            }

            if (added > parkingLotSize)
                flag = false;
            ++moment;
        }

        if (!flag)
            result = "Nao";
        System.out.println(result);
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        draw();
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
