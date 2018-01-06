import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1808
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	static String inlet;
	static double outlet;

	public static void main(String[] args)
	throws IOException
	{
		while (true)
		{
			try {
				process();
			}
			catch (Exception any) {
				break;
			}
		}

		BR.close();
		ISR.close();
	}

	static void process()
	throws IOException
	{
		inlet = BR.readLine();
		outlet = 0.0;
		int n = 0;

		for (int c = 0; c < inlet.length(); c++)
		{
			if (inlet.charAt(c) == '1') {
				try {
					if (inlet.charAt(c+1) == '0') {
						outlet += 10;
						c++;
					}
					else {
						outlet += 1;
					}
				}
				catch (Exception any) {
					outlet += 1;
				}
			}
			else {
				outlet += inlet.charAt(c) - '0';
			}

			n++;
		}

		System.out.printf("%.2f\n", outlet/n);
	}
}
