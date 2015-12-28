import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1084 {
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(ir);

    static int numberDigits;
    static int toErase;
    static String numbers;

    public static void main(String[] args)
    throws IOException
    {
        while (true)
        {
          try {
              setup();
              draw();
          }
          catch (Exception any) {
              break;
          }
        }

        in.close();
        ir.close();
    }

    static void setup()
    throws IOException
    {

    }

    static void draw()
    throws IOException
    {
        
    }
}
