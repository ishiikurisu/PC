import java.io.*;

public class uri1212 {
	static InputStreamReader ir = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(ir);

	static String[] numbers = new String[2];
	static int count;

	static boolean readData() throws IOException {
		boolean flag = true;
		
		numbers = in.readLine().split(" ");
		if (Integer.parseInt(numbers[0]) == 0 && 
Integer.parseInt(numbers[1]) == 0)
			flag = false;

		return flag;
	}

	static void processData() {
		int i = numbers[0].length();
		int j = numbers[1].length();
		int carry = 0;
		count = 0;

		while (i > 0 && j > 0) {
			int up = Integer.parseInt(numbers[0].substring(i - 1, i));
			int dn = Integer.parseInt(numbers[1].substring(j - 1, j));
			int sum = up + dn + carry;
			
			if (sum >= 10) {
				carry = 1;
				count++;
			}

			i--; j--;
		}
	}

	static void writeData() {
		if (count == 0)
			System.out.println("No carry operation.");
		else if (count == 1)
			System.out.println("1 carry operation.");
		else
			System.out.println(count + " carry operations.");
	}

	public static final void main(String[] args) throws IOException {
		while(readData()) {
			processData();
			writeData();
		}
	}
}
