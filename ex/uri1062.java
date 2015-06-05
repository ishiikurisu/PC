import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class uri1062
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int numberWagons;
    static String referenceWagons;
    static HashMap<String, HashSet> memo;

    static boolean loop(LinkedList<Integer> station,
                        LinkedList<Integer> railroad)
    {
        String stationString = station.toString();
        String railString = railroad.toString();

        System.out.println("  " + stationString + "+" + railString);

        if (referenceWagons.equals(stationString))
            return true;
        if (memo.containsKey(stationString)) {
            if (memo.get(stationString).contains(railString))
                return false;
            else
                memo.get(stationString).add(railString);
        }
        else {
            memo.put(stationString, new HashSet<String>());
        }

        LinkedList<Integer> newStation;
        LinkedList<Integer> newRail;
        boolean result = false;

        if (railroad.size() > 0) {
            newStation = new LinkedList<Integer>(station);
            newRail = new LinkedList<Integer>(railroad);
            newStation.add(0, newRail.remove(0));
            result = loop(newStation, newRail);
        }
        if (result == true) return result;

        if (station.size() > 0) {
            newStation = new LinkedList<Integer>(station);
            newRail = new LinkedList<Integer>(railroad);
            newRail.offer(newStation.remove(0));
            result = loop(newStation, newRail);
        }

        return result;
    }

    static void setup()
    throws IOException
    {
        LinkedList<Integer> wagons = new LinkedList<Integer>();

        numberWagons = Integer.parseInt(BR.readLine());
        if (numberWagons == 0) throw new IOException();

        memo = new HashMap<String, HashSet>();

        for (int w = 1; w <= numberWagons; ++w)
            wagons.add(0, w);

    }

    static void draw()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int endOfLine = Integer.parseInt(line[0]);
        LinkedList<Integer> station = new LinkedList<Integer>();
        LinkedList<Integer> railroad = new LinkedList<Integer>();

        if (endOfLine == 0)
            throw new IOException();

        for (int w = 0; w < numberWagons; ++w)
            railroad.offer(Integer.parseInt(line[w]));
        referenceWagons = railroad.toString();

        railroad = new LinkedList<Integer>();
        for (int w = 1; w <= numberWagons; ++w)
            railroad.add(w);

        if (loop(station, railroad))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args)
    throws IOException
    {
        while (true)
        {
            try {
                setup();
                while (true) {
                    try { draw(); }
                    catch (Exception end) {
                        System.out.println();
                        break;
                    }
                }
            }
            catch (Exception any) {
                break;
            }
        }

        BR.close();
        ISR.close();
    }
}
