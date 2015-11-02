import java.io.*;
import java.util.*;

public class uri1258
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	static int numberRequests;
	static Map<String, Map> color;
	static String[] colors = {"branco", "vermelho"};
	static String[] sizes = {"P", "M", "G"};

	public static void main(String[] args)
	throws IOException
	{
		boolean firstCase = true;

		for (numberRequests = Integer.parseInt(BR.readLine());
		     numberRequests != 0;
			 numberRequests = Integer.parseInt(BR.readLine()))
		{
			if (firstCase)
				firstCase = false;
			else
				System.out.println();
			setup();
			draw();
		}
	}

	static void setup()
	throws IOException
	{
		color = new HashMap<String, Map>();

		for (int i = 0; i < numberRequests; ++i)
		{
			String person = BR.readLine();
			String data[] = BR.readLine().split("\\s+");

			if (!color.containsKey(data[0]))
				color.put(data[0], new HashMap<String, List>());
			Map<String, List> size = color.get(data[0]);
			if (!size.containsKey(data[1]))
				size.put(data[1], new ArrayList<String>());
			size.get(data[1]).add(person);
		}
	}

	static void draw()
	{
		for (String currentColor: colors)
		{
			if (color.containsKey(currentColor)) {
				Map<String, List> size = color.get(currentColor);
				for (String currentSize: sizes)
				{
					if (size.containsKey(currentSize)) {
						List<String> requests = size.get(currentSize);
						Collections.sort(requests);
						for (String person: requests)
						{
							System.out.print(currentColor + " ");
							System.out.print(currentSize + " ");
							System.out.println(person);
						}
					}
				}
			}
		}
	}
}
