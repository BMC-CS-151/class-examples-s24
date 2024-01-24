import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BreakThings {

  //TODO: Let's go through line by line... what will happen?
  public static void main(String[] args) throws FileNotFoundException {

    Scanner input = new Scanner(new File("NotARealFile.txt"));

//if length args == 0:
    String arg1 = args[0];

 //   Object broken = null;
//    System.out.println(broken.toString());
    
    int reallyBroken = 100 / 0;

  }

}
