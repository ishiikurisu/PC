import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	
	static double log(double n)
	{ return Math.log(n); }
	static double pow(double a, double b)
	{ return Math.pow(a, b); }
	
	static int z(int n)
	{
		int k = (int) (log(n)/log(5)) - 1;
		int out = 0;
		
		for (int i = 1; i < k; ++i)
			out += (int) n / pow(5, i);
			
		return out;
	}
	
	public static void main(String[] args) throws IOException
	{
		int T, t;
		int N;
		
		T = Integer.parseInt(BR.readLine());
		for (t = 0; t < T; ++t)
		{
			N = Integer.parseInt(BR.readLine());
			System.out.println(z(N));
		}
	}
}