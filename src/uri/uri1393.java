import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;

public class uri1393
{
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	public static void main(String[] args)
	throws IOException
	{
		int numberTiles = 0;

		while ((numberTiles = Integer.parseInt(BR.readLine())) > 0)
			System.out.println(proc(numberTiles));
		BR.close();
		ISR.close();
	}

	static int proc(int tiles)
	{
		int result = 1;

		if (tiles <= 2) {
			result = tiles;
		}
		else if (memo.containsKey(tiles)) {
			result = memo.get(tiles);
		}
		else {
			result = proc(tiles-1) + proc(tiles-2);
			memo.put(tiles, result);
		}

		return result;
	}
}
