import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);
        int i, j, k;
        String password = BR.readLine();
        int noCommands = Integer.parseInt(BR.readLine());

        for (int c = 0; c < noCommands; c++)
        {
            String action = BR.readLine();
            String[] asdf = action.split("\\s+");
            int limit = asdf.length;
            int[] skeleton = new int[limit];
            for (int d = 0; d < limit; ++d) {
                skeleton[d] = Integer.parseInt(asdf[d]);
            }
            switch (skeleton[0]) {
                case 1:
                    i = skeleton[1]-1;
                    j = skeleton[2];
                    k = skeleton[3];
                    System.out.println((password.substring(i, j).equals(password.substring(k, k+j-i)))? "Y" : "N");
                break;

                case 2:
                    
                break;

                case 3:
                    System.out.println(password);
                break;
            }
        }


        BR.close();
        ISR.close();
    }
}
