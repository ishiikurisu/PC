import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class spojTRGRID
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int N;
    static int M;
    static boolean[][] G;

    static String[] directions = {
        "D",
        "L",
        "U",
        "R"
    };

    static int[][] changes = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    static boolean allVisited()
    {
        for (int n = 0; n < N; ++n)
            for (int m = 0; m < M; ++m)
                if (G[n][m] == false)
                    return false;
        return true;
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        G = new boolean[N][M];

        for (int n = 0; n < N; ++n)
            for (int m = 0; m < M; ++m)
                G[n][m] = false;
    }

    static void draw()
    throws IOException
    {
        int step = 0;
        int[] P = new int[2];
        String D = directions[step];
        int[] C = changes[step];

        P[0] = P[1] = 0;
        while (!allVisited())
        {
            int X = P[0] + C[0];
            int Y = P[1] + C[1];

            if (X == N || Y == M || X < 0 || Y < 0 || !G[X][Y]) {
                ++step;
                D = directions[step % 4];
                C = changes[step % 4];
                P[0] += C[0];
                P[1] += C[1];
            }
            else {
                P[0] = X;
                P[1] = Y;
            }

            G[P[0]][P[1]] = true;
        }

        System.out.println(D);
    }

    public static void main(String[] args)
    throws IOException
    {
        int T = Integer.parseInt(BR.readLine());

        for (int t = 0; t < 0; ++t)
        {
            setup();
            draw();
        }

        BR.close();
        ISR.close();
    }
}
