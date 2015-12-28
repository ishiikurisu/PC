import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);

    static int N, D;
    static int[] inlet;
    static int outlet;

    static int max(int a, int b)
    { return (a > b)? a : b; }

	static int rec(int pos, int add, int sum)
    {
        if (pos == N || add == N - D)
            return sum;

        int x = rec(pos + 1, add + 1, sum * 10 + inlet[pos]);
        int y = rec(pos + 1, add, sum);
        return max(x, y);
    }

    static void readData() throws IOException
	{
		String[] line = BR.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        D = Integer.parseInt(line[1]);
        if (N == 0 && D == 0) throw new IOException();

        String number = BR.readLine();
        inlet = new int[N];
        for (int i = 0; i < N; ++i)
            inlet[i] = Integer.parseInt(number.substring(i, i + 1));
	}

	static void processData()
	{
		outlet = 0;

        for (int i = 0; i < N - 1; ++i)
            outlet = max(outlet, rec(i, 0, 0));
	}

	static void writeData()
	{
		System.out.println("" + outlet);
	}

	public static void main(String[] args)
	{
		while (true)
		{
			try
			{
				readData();
				processData();
				writeData();
			}
			catch (Exception any) { break; }
		}
	}
}
