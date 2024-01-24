import java.util.Scanner;
import java.io.*;

public class Handling {

  public static void read() {
    Scanner input;
    try {
      input = new Scanner("foo.txt");
    } catch (Exception e) {
      System.out.println("no file");
      return;
    } catch 9ArrayOutOfBoundsException e) {

})

    String line;
    while (input.hasNextLine()) { 
      line = input.nextLine();
      System.out.println(line);
    }

    input.close();
  }

  public static void main(String[] args) {
    read();
  }
}
