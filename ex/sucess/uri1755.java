import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1755
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    public static void main(String[] args)
    throws IOException
    {
        int N = Integer.parseInt(BR.readLine());

        for (int n = 0; n < N; ++n)
            loop();

        BR.close();
        ISR.close();
    }

    static void loop()
    throws IOException
    {
        String[] line = BR.readLine().split("\\s+");
        int numberProducts = Integer.parseInt(line[1]);
        double availableMoney = Double.parseDouble(line[0]);
        double biggestChange = 0.0;

        line = BR.readLine().split("\\s+");
        for (int i = 0; i < numberProducts; ++i)
        {
            double currentPrice = Double.parseDouble(line[i]);
            double currentChange = availableMoney % currentPrice;

            if (currentChange > biggestChange && currentPrice < availableMoney) {
                biggestChange = currentChange;
            }
        }

        System.out.printf("%.2f\n", biggestChange);
    }
}
