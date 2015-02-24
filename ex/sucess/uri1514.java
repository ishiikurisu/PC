import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(isr);
	
	static int N;
	static int M;
	static boolean[][] R;
	
	/* AUXILIAR FUNCTIONS */
	// ninguem resolveu todos os problemas
	static int cond1() {
		boolean flag = true;
		
		for (int i = 0; i < N; ++i) {
			flag = false;
			for (int j = 0; j < M && !flag; ++j)
				if (R[i][j] == false)
					flag = true;
			if (flag == false)
				break;
		}
		
		if (flag) return 1;
		else return 0;
	}
	
	// todo problema foi resolvido por pelo menos uma pessoa
	static int cond2() {
		boolean flag = true;
		
		for (int j = 0; j < M; ++j) {
			flag = false;
			for (int i = 0; i < N && !flag; ++i)
				if (R[i][j] == true)
					flag = true;
			if (flag == false)
				break;
		}
		
		if (flag) return 1;
		else return 0;
	}
	
	// nao ha nenhum problema resolvido por todos
	static int cond3() {
		boolean flag = false;
		int count = 0;
		
		for (int j = 0; j < M && !flag; ++j) {
			count = 0;
			for (int i = 0; i < N; ++i)
				if (R[i][j] == true)
					++count;
			if (count == N)
				flag = true;
		}
		
		if (!flag) return 1;
		else return 0;
	}
	
	// ninguem resolveu todos os problemas
	static int cond4() {
		boolean flag = false;
		
		for (int i = 0; i < N; ++i) {
			flag = false;
			for (int j = 0; j < M && !flag; ++j)
				if (R[i][j] == true)
					flag = true;
			if (flag == false)
				break;
		}
		
		if (flag) return 1;
		else return 0;
	}
	
	/* MAIN FUNCTIONS */
	static void setup() throws IOException {
		String[] inlet = in.readLine().split(" ");
		N = Integer.parseInt(inlet[0]);
		M = Integer.parseInt(inlet[1]);
		if (N == 0 || M == 0) throw new IOException();
		R = new boolean[N][M];
		for (int n = 0; n < N; ++n) {
			inlet = in.readLine().split(" ");
			for (int m = 0; m < M; ++m) {
				if (inlet[m].charAt(0) == '0')
					R[n][m] = false;
				else
					R[n][m] = true;
			}
		}
	}
	
	static void draw() {
		int count = 0;
		
		// ninguem resolveu todos os problemas
		count += cond1();
		// todos os problemas foram resolvidos por pelo menos uma pessoa
		count += cond2();
		// nao ha um problema resolvido por todos
		count += cond3();
		// todos resolveram ao menos um problema
		count += cond4();
		
		System.out.println(count);
	}
	
	public static void main (String[] args) {
		while (true) {
			try {
				setup();
				draw();
			} catch (Exception any) {
				break;
			}
		}
	}
}
