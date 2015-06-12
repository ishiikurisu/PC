import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;

public class uva10114
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int loanDuration;
    static double downPayment;
    static double loanAmount;
    static int numberRecords;
    static HashMap<Integer, Double> interestRates;

    static void say(String input)
    {
        System.out.println(input);
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        int month;
        double rate;

        loanDuration = Integer.parseInt(line[0]);
        downPayment = Double.parseDouble(line[1]);
        loanAmount = Double.parseDouble(line[2]);
        numberRecords = Integer.parseInt(line[3]);
        interestRates = new HashMap<Integer, Double>();

        if (loanDuration < 0)
            throw new IOException();

        for (int record = 0; record < numberRecords; ++record)
        {
            line = BR.readLine().split(" ");
            month = Integer.parseInt(line[0]);
            rate = Double.parseDouble("0" + line[1]);
            interestRates.put(month, rate);
        }
    }

    static void draw()
    throws IOException
    {
        int month = 0;
        double rate = interestRates.get(month);
        double money = loanAmount;
        double carValue = (loanAmount + downPayment) * (1 - rate);

        downPayment = loanAmount / loanDuration;
        while (money > carValue && month < loanDuration)
        {
            month++;

            if (interestRates.containsKey(month))
                rate = interestRates.get(month);

            money -= downPayment;
            carValue -= carValue * rate;
        }

        if (month == 1)
            System.out.println("1 month");
        else
            System.out.println(month + " months");
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
