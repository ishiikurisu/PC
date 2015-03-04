import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(ISR);
	
	public static void main (String[] args) throws IOException
	{
		String line;
		BigInteger inlet;
		int numberCases;
		
		line = in.readLine();
		numberCases = Integer.parseInt(line);
		
		for (int c = 0; c < numberCases; c++)
		{	
			line = in.readLine();
			inlet = new BigInteger(line);
			System.out.println(inlet.bitCount());
		}
	}
}
