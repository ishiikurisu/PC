import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1121 {
	static InputStreamReader ir = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(ir);

	static int numberLines;
	static int numberColumns;
	static int direction;
	static char[][] arena;
	static String instructions;
	static int[] position;

	static void readData()
	throws IOException
	{
		String raw = in.readLine();
		String[] line = raw.split("\\s+");

		numberLines = Integer.parseInt(line[0]);
		numberColumns = Integer.parseInt(line[1]);
		arena = new char[numberLines][numberColumns];
		position = new int[2];

		if (numberLines == 0 && numberColumns == 0)
			throw new IOException();

		for (int j = 0; j < numberLines; ++j)
		{
			raw = in.readLine();
			for (int i = 0; i < numberLines; ++i)
			{
				char data = raw.charAt(i);

				switch (data)
				{
					case 'N': direction = 0; break;
					case 'L': direction = 1; break;
					case 'S': direction = 2; break;
					case 'O': direction = 3; break;
				}

				if (data == 'N' || data == 'S' || data == 'L' || data == 'O') {
					position[0] = j;
					position[1] = i;
				}

				arena[j][i] = data;
			}
		}

		instructions = in.readLine();
	}

	static void processData() {
		int cards = 0;

		for (int i = 0; i < instructions.length(); ++i)
		{
			switch (instructions.charAt(i))
			{
				case 'D':
					direction = (direction+1) % 4;
				break;

				case 'E':
					direction = (direction-1) % 4;
				break;

				case 'F':
					cards += judge();
				break;
			}

			if (direction < 0) direction += 4;
		}

		System.out.println(cards);
	}

	static int judge()
	{
		int py = position[0];
		int px = position[1];
		int sy = -1;
		int sx = 0;
		int c = 0;

		switch (direction)
		{
			case 1: sy = 0; sx = 1; break;
			case 2: sy = 1; sx = 0; break;
			case 3: sy = 0; sx = -1; break;
		}

		// unable to leave the arena
		if ((px+sx >= numberColumns) || (py+sy) >= numberLines ||
		(px+sx < 0) || (py+sy < 0)) {
			c = 0;
		}
		// unable to break a wall
		else if (arena[py+sy][px+sx] == '#') {
			c = 0;
		}
		// get the card
		else if (arena[py+sy][px+sx] == '*') {
			arena[py][px] = '.';
			py += sy;
			px += sx;
			c = 1;
			arena[py][px] = '#';
		}
		else {
			arena[py][px] = '.';
			py += sy;
			px += sx;
			arena[py][px] = '#';
		}

		position[0] = py;
		position[1] = px;
		return c;
	}

	public static void main(String[] args) throws IOException {
		readData();

		while (true)
		{
			try {
				processData();
				readData();
			}
			catch (Exception any) {
				break;
			}
		}

		in.close();
		ir.close();
	}

}
