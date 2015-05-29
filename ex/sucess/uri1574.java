import java.util.*;
import java.io.*;

public class uri1574 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static void main(String[] args) throws IOException {
    int numberCases, numberCommands, position = 0;
    BitSet commands;

    try {
      numberCases = Integer.parseInt(in.readLine());
      for (int n = 0; n < numberCases; n++) {
        numberCommands = Integer.parseInt(in.readLine());
        commands = new BitSet(numberCommands);
        position = 0;

        for (int c = 0; c < numberCommands; c++) {
          String command = in.readLine();

          if (command.equals("RIGHT")) {
            commands.set(c, true);
            position++;
          }
          else if (command.equals("LEFT")) {
            commands.set(c, false);
            position--;
          }
          else {
            int index = Integer.parseInt(command.split(" ")[2]);
            position += (commands.get(index-1))? 1: -1;
            commands.set(c, commands.get(index-1));
          }
        }
        System.out.println(position);
      }
    }
    catch (Exception NumberFormatException) {}
  }

}
