import java.util.*;
import java.io.*;

public class uri1523
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static long numberDrivers;
    static long parkingLotSize;
    static HashMap<Long, Long> arrival;
    static HashMap<Long, Long> departure;

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        numberDrivers = Long.parseLong(line[0]);
        parkingLotSize = Long.parseLong(line[1]);

        if (numberDrivers == 0 && parkingLotSize == 0)
            throw new IOException();

        arrival = new HashMap<Long, Long>();
        departure = new HashMap<Long, Long>();

        for (long i = 0; i < numberDrivers; ++i)
        {
            line = BR.readLine().split(" ");
            arrival.put(Long.parseLong(line[0]), i);
            departure.put(Long.parseLong(line[1]), i);
        }
    }

    static void draw()
    {
        ArrayList<Long> parkingLot = new ArrayList<Long>();
        String result = "Sim";
        boolean flag = true;
        long added = 0;
        long moment = 0;
        long driver = 0;

        while (flag && !departure.isEmpty())
        {
            if (departure.containsKey(moment)) {
                driver = departure.get(moment);
                if (driver == parkingLot.get(0)) {
                    departure.remove(moment);
                    parkingLot.remove(0);
                    --added;
                }
                else
                    flag = false;
            }
            if (arrival.containsKey(moment)) {
                driver = arrival.get(moment);
                parkingLot.add(0, driver);
                ++added;

                if (added > parkingLotSize)
                    flag = false;
            }

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
