import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;

public class uri1246
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static final int price = 10;
    static final String arrival = "C";
    static final String depture = "S";
    static int numberEvents;
    static int parkingLotSize;
    static String[] parkingLot;

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
                // System.out.println(any);
                break;
            }
        }

        BR.close();
        ISR.close();
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");

        parkingLotSize = Integer.parseInt(line[0]);
        numberEvents = Integer.parseInt(line[1]);
        parkingLot = new String[parkingLotSize];

        for (int i = 0; i < parkingLotSize; ++i) {
            parkingLot[i] = null;
        }
    }

    static void draw()
    throws IOException
    {
        HashMap<String, Integer> lotToCar = new HashMap<String, Integer>();
        int currentLot = -1;
        int firstLot = 0;
        int money = 0;

        for (int event = 0; event < numberEvents; ++event)
        {
            String what = BR.readLine();
            String[] line = what.split(" ");
            String eventKind = line[0];
            String licensePlate = line[1];

            // System.out.println(what);
            if (eventKind.equals(arrival)) {
                int carSize = Integer.parseInt(line[2]);
                currentLot = fitsInLot(carSize);
                // System.out.println("  " + currentLot);
                if (currentLot >= 0) {
                    fillLot(currentLot, carSize, licensePlate);
                    lotToCar.put(licensePlate, currentLot);
                    money += price;
                }
            }
            else {
                currentLot = lotToCar.get(licensePlate);
                freeLot(currentLot, licensePlate);
                lotToCar.remove(licensePlate);
            }

            firstLot = findFirstLot();
            // writeLot();
        }

        System.out.println(money);
    }

    static int fitsInLot(int size)
    {
        int result = -1;
        int lot = 0;
        int current = 0;

        for (int i = 0; i < parkingLotSize && result < 0; ++i)
        {
            if (parkingLot[i] == null) {
                if (current < 0) {
                    lot = i;
                    current++;
                }
                current++;
            }
            else {
                current = -1;
            }

            if (current == size) {
                result = lot;
            }
        }

        return result;
    }

    static void fillLot(int firstLot, int size, String plate)
    {
        for (int i = 0; i < size; ++i)
            parkingLot[firstLot + i] = plate;
    }

    static void freeLot(int firstLot, String plate)
    {
        int i = firstLot;
        String car = parkingLot[i];

        while (car != null && plate.equals(car) && i < parkingLotSize)
        {
            parkingLot[i] = null;
            ++i;
            if (i < parkingLotSize) {
                car = parkingLot[i];
            }
        }
    }

    static int findFirstLot()
    {
        int result = -1;

        for (int place = 0; place < parkingLotSize && result < 0; ++place)
            if (parkingLot[place] == null)
                result = place;

        return result;
    }

    static void writeLot()
    {
        for (int i = 0; i < parkingLotSize; ++i) {
            System.out.printf("%s\t", parkingLot[i]);
        }

        System.out.println();
    }
}
