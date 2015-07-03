import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class uri1277
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static final Double minimum = 0.75;
    static String[] students;
    static Double[] presence;
    static int numberStudents;

    public static void main(String[] args)
    throws IOException
    {
        int T = Integer.parseInt(BR.readLine());

        for (int t = 0; t < T; ++t)
        {
            setup();
            draw();
        }

        BR.close();
        ISR.close();
    }

    static void setup()
    throws IOException
    {
        numberStudents = Integer.parseInt(BR.readLine());
        students = BR.readLine().split(" ");
        presence = new Double[numberStudents];

        String[] classes  = BR.readLine().split(" ");
        for (int i = 0; i < numberStudents; ++i)
        {
            Double numberClasses = 0.0;
            Double numberPresences = 0.0;
            String pattern = classes[i];

            for (int c = 0; c < pattern.length(); c++)
            {
                switch (pattern.charAt(c))
                {
                    case 'P':
                        numberPresences++;
                    case 'A':
                        numberClasses++;
                }

            }

            presence[i] = numberPresences / numberClasses;
        }
    }

    static void draw()
    {
        boolean firstStudent = true;

        for (int i = 0; i < numberStudents; ++i)
        {
            if (presence[i] < minimum) {
                if (firstStudent)
                    firstStudent = false;
                else
                    System.out.printf(" ");
                System.out.printf("%s", students[i]);
            }
        }

        System.out.printf("\n");
    }
}
