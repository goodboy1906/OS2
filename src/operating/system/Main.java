package operating.system;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

  public static void menu() throws NoSuchAlgorithmException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n1. Single threaded mode");
    System.out.println("2. Multithreaded mode");
    System.out.print(">>> ");

    int menuArg = scanner.nextInt();

    switch (menuArg){
      case 1:
        System.out.println(Algorithm.singleThreadedMode());
        menu();
      case 2:
        menu();
      default:
        System.out.println("\nWrong argument!\n");
        menu();
    }
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    menu();
  }
}
