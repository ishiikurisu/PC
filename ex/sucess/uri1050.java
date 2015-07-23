import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;

public class uri1050
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);
    static HashMap<String, String> DDD = new HashMap<String, String>();

    public static void main(String[] args)
    throws IOException
    {
        setup();
        draw();

        BR.close();
        ISR.close();
    }

    static void setup()
    {
        DDD.put("61", "Brasilia");
        DDD.put("71", "Salvador");
        DDD.put("11", "Sao Paulo");
        DDD.put("21", "Rio de Janeiro");
        DDD.put("32", "Juiz de Fora");
        DDD.put("19", "Campinas");
        DDD.put("27", "Vitoria");
        DDD.put("31", "Belo Horizonte");
    }

    static void draw()
    throws IOException
    {
        String input = BR.readLine();
        String output = null;

        if (DDD.containsKey(input))
            output = DDD.get(input);
        else
            output = "DDD nao cadastrado";

        System.out.println(output);
    }
}
