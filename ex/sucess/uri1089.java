import java.io.*;

public class uri1089 {
	static InputStreamReader ir = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(ir);
	
	static int size;
	static int[] notes;
	static int peaks;

	static boolean readData() throws IOException {
		boolean flag = true;

		size = Integer.parseInt(in.readLine());
		if (size == 0)		
			flag = false;
		else {
			notes = new int[size];
			String[] sequence = in.readLine().split(" ");
			for (int i = 0; i < size; ++i) {
				notes[i] = 
Integer.parseInt(sequence[i]);
			}
		}

		return flag;
	}

	static void processData() {
		int before, next;
		peaks = 0;

		for (int i = 0; i < size; ++i) {
			// delimiting limits
			if (i == 0) {
				before = size - 1;
				next = i + 1;
			}
			else if (i == size - 1) {
				before = i - 1;
				next = 0;
			}
			else {
				before = i - 1;
				next = i + 1;
			}

			// 	
			if ((notes[i] > notes[before] && notes[i] > 
notes[next]) || (notes[i] < notes[before] && notes[i] < notes[next])) {
				peaks++;
			}
		}
	}	

	static void writeData() {
		System.out.println(peaks);
	}

	public static final void main(String[] args) throws IOException {
		while (readData()) {
			processData();
			writeData();
		}
	}
}
