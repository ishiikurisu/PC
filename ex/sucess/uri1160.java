import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1160 {
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static long PA, PB;
    static double G1, G2;

    static void setup()
    throws IOException
    {
        String[] input = BR.readLine().split(" ");

        PA = Long.parseLong(input[0]);
        PB = Long.parseLong(input[1]);
        G1 = Double.parseDouble(input[2]);
        G2 = Double.parseDouble(input[3]);

        G1 = (100.0 + G1) / 100.0;
        G2 = (100.0 + G2) / 100.0;
    }

    static void draw()
    {
        String output = "Mais de 1 seculo.";
        int time = 0;

        while (PA < PB && time <= 100)
        {
            PA = (long) PA * G1;
            PB = (long) PB * G2;
            ++time;
        }

        if (time <= 100)
            output = time + " anos.";
        System.out.println(output);
    }

    public static void main(String[] args)
    throws IOException
    {
        int T = Integer.parseInt(BR.readLine());

        for (int t = 0; t < T; ++t)
        {
            setup();
            draw();
        }

        BR.close();
        ISR.close();
    }
}
