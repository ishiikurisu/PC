import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	
	static int N;
	static double[][] PTS;
	static double D;
	
	static double min(double a, double b)
	{ return (a < b)? a > b; }
	
	static double distance(double[] a, double[] b)
	{
		
	}
	
	static void readData() throws IOException
	{
		String[] inlet;
		N = Integer.parseInt(BR.readLine());
		if (N = 0) throw new IOException();
		PTS = new double[N][2];
		
		for (int i = 0; i < N; ++i)
		{
			inlet = BR.readLine().split(" ");
			for (int j = 0; j < 2; ++j)
				PTS[i][j] = Double.parseDouble(inlet[j]);
		}
	}
	
	static void processData()
	{
		D = 0x7FFFFFFF;
		
		
	}
	
	static void writeData()
	{ System.out.printf("%.3f\n", D); }
	
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