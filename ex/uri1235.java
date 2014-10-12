import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1235 {
	static InputStreamReader ir = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(ir);

	public static final void main(String[] args) throws IOException {
		int numberCases = Integer.parseInt(in.readLine());

		for (int c = 0; c < numberCases; c++) {
			String line = in.readLine();
			int length = line.length();
			for (int i = length/2-1; i >= 0; --i)
				System.out.print(line.charAt(i));
			for (int i = length-1; i >= length/2; --i)
				System.out.print(line.charAt(i));

			System.out.println();
		}
	}
}
