import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1351
{
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(isr);
    static final double UNKNOWN = 10000000;

    static int numberItens;
    static int numberAisles;
    static int[] item;
    static int[] aisle;
    static double[] price;
    static double[][] memo;
    static double bestPrice;

    static double min(double a, double b)
    {
        return (a < b)? a : b;
    }

    static double evaluate(int it, int ai, double cp)
    {
        double result;

        if (memo[it][ai] > 0)
          result = memo[it][ai];
        if (it == numberItens)
            result = cp;
        else if (ai == numberAisles)
            result = UNKNOWN;
        else if (aisle[ai] == item[it])
            result = min(evaluate(it, ai+1, cp), evaluate(it+1, ai+1, cp + price[ai]));
        else
            result = evaluate(it, ai+1, cp);

        memo[it][ai] = result;
        return result;
    }

    static void readData() throws IOException
    {
        String[] line = in.readLine().split(" ");
        numberItens = Integer.parseInt(line[0]);
        numberAisles = Integer.parseInt(line[1]);

        if (numberItens == 0 || numberAisles == 0)
            throw new IOException();

        item = new int[numberItens];
        aisle = new int[numberAisles];
        price = new double[numberAisles];
        line = in.readLine().split(" ");
        for (int i = 0; i < numberItens; ++i)
            item[i] = Integer.parseInt(line[i]);
        for (int a = 0; a < numberAisles; ++a)
        {
            line = in.readLine().split(" ");
            aisle[a] = Integer.parseInt(line[0]);
            price[a] = Double.parseDouble(line[1]);
        }
    }

    static void processData()
    {
        memo = new double[numberItens+1][numberAisles+1];
        bestPrice = evaluate(0, 0, 0.0);
    }

    static void writeData()
    {
        if (bestPrice <= 0 || bestPrice == UNKNOWN)
            System.out.println("Impossible");
        else
            System.out.printf("%.2f\n", bestPrice);
    }

    public static final void main(String[] args)
    {
        while (true)
        {
            try
            {
                readData();
                processData();
                writeData();
            }
            catch (Exception any)
            {
                break;
            }
        }
    }
}
