import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1304 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static long pastMoment;
  static long presentMoment;
  static double speed;
  static double distance;
  static boolean changeSpeed;
  static String lastMoment;

  static void loop() throws IOException {
    String[] line = in.readLine().split(" ");
    String[] clock;
    double newSpeed;

    /* read moment */
    clock = line[0].split(":");
    presentMoment = Integer.parseInt(clock[2]);
    presentMoment += Integer.parseInt(clock[1]) * 60;
    presentMoment += Integer.parseInt(clock[0]) * 3600;

    /* update distance */
    distance += (long) speed * (presentMoment - pastMoment);
    pastMoment = presentMoment;
    if (changeSpeed == true) {
      draw();
      changeSpeed = false;
    }

    /* change speed */
    try {
      speed = Integer.parseInt(line[1]);
      changeSpeed = true;
    } catch (ArrayIndexOutOfBoundsException aeiou) { }
    lastMoment = line[0];
  }

  static void draw() {
    System.out.printf("%s %.2f km\n", lastMoment, distance/3600);
  }

  public static final void main(String[] args) {
    speed = distance = 0;
    pastMoment = 0;
    changeSpeed = false;

    while (true) {
      try { loop(); }
      catch (Exception any) { break; }
    }

    draw();
    try {
      in.close();
      isr.close();
    }
    catch (IOException ioe) { }
  }
}
