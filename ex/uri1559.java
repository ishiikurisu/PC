import java.io.*;
import java.util.*;

/* wrong answer (10%) */
public class uri1559
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static String[] moves = {"DOWN", "LEFT", "RIGHT", "UP"};
    static int[][] board2048 = new int[4][4];
    static boolean[] possible = new boolean[4];

    public static void main(String[] args)
    throws IOException
    {
        int limit = Integer.parseInt(BR.readLine());

        for (int i = 0; i < limit; ++i)
        {
            load();
            update();
            draw();
        }

        BR.close();
        ISR.close();
    }

    public static void load()
    throws IOException
    {
        for (int i = 0; i < 4; ++i)
        {
            String[] line = BR.readLine().split("\\s+");
            for (int j = 0; j < 4; ++j)
            {
                board2048[j][i] = Integer.parseInt(line[j]);
            }
        }
    }

    public static void update()
    {
        possible[0] = down();
        possible[1] = left();
        possible[2] = right();
        possible[3] = up();
    }

    public static void draw()
    {
        String result = "NONE";
        boolean flag = false;

        for (int i = 0; i < possible.length; ++i) {
            if (possible[i] == true) {
                if (flag) {
                    result += " " + moves[i];
                }
                else {
                    flag = true;
                    result = moves[i];
                }
            }
        }

        System.out.println(result);
    }

    private static boolean right()
    {
        boolean flag = false;

        for (int i = 0; i < 4 && !flag; ++i)
        {
            int n = 0;
            for (int j = 0; j < 4 && !flag; ++j)
            {
                if (board2048[j][i] != 0) {
                    if (n == 0)
                        n = board2048[j][i];
                    else if (n == board2048[j][i])
                        flag = true;
                    else
                        n = board2048[j][i];
                }
                else if (n != 0) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static boolean down()
    {
        boolean flag = false;

        for (int j = 0; j < 4 && !flag; ++j)
        {
            int n = 0;
            for (int i = 0; i < 4 && !flag; ++i)
            {
                if (board2048[j][i] != 0) {
                    if (n == 0)
                        n = board2048[j][i];
                    else if (n == board2048[j][i])
                        flag = true;
                    else
                        n = board2048[j][i];
                }
                else if (n != 0) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static boolean up()
    {
        boolean flag = false;

        for (int j = 3; j >= 0 && !flag; --j)
        {
            int n = 0;
            for (int i = 3; i >= 0 && !flag; --i)
            {
                if (board2048[j][i] != 0) {
                    if (n == board2048[j][i])
                        flag = true;
                    else
                        n = board2048[j][i];
                }
                else if (n != 0) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static boolean left()
    {
        boolean flag = false;

        for (int i = 3; i >= 0 && !flag; --i)
        {
            int n = 0;
            for (int j = 3; j >= 0 && !flag; --j)
            {
                if (board2048[j][i] != 0) {
                    if (n == 0)
                        n = board2048[j][i];
                    else if (n == board2048[j][i])
                        flag = true;
                    else
                        n = board2048[j][i];
                }
                else if (n != 0) {
                    flag = true;
                }
            }
        }

        return flag;
    }
}
