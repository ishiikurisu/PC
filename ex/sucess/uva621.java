import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashSet;

public class uva621
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static HashSet<String> memo = new HashSet<String>();
    static int numberCases = 0;

    final static String positiveResult = "+";
    final static String negativeResult = "-";
    final static String failedExperiment = "*";
    final static String notCompleted = "?";

    /* S35 */
    static boolean isNegativeResult(String input)
    {
        boolean result = false;
        int length = input.length();

        if (input.substring(length - 2, length).equals("35"))
            result = true;

        return result;
    }

    /* 9S4 */
    static boolean isExperimentFailed(String input)
    {
        boolean result = false;
        int length = input.length();

        if (input.charAt(0) == '9' && input.charAt(length - 1) == '4')
            result = true;

        return result;
    }

    /* 190S */
    static boolean isNotCompletedExperiment(String input)
    {
        boolean result = false;

        if (input.substring(0, 3).equals("190"))
            result = true;

        return result;
    }

    static void setup()
    throws IOException
    {
        numberCases = Integer.parseInt(BR.readLine());

        memo.add("1");
        memo.add("4");
        memo.add("78");
    }

    static void draw()
    throws IOException
    {
        String input = BR.readLine();

        if (memo.contains(input))
            System.out.println(positiveResult);
        else if (isNegativeResult(input))
            System.out.println(negativeResult);
        else if (isExperimentFailed(input))
            System.out.println(failedExperiment);
        else if (isNotCompletedExperiment(input))
            System.out.println(notCompleted);
    }

    public static void main(String[] args)
    throws IOException
    {
        setup();
        for (int c = 0; c < numberCases; c++)
            draw();

        BR.close();
        ISR.close();
    }
}
