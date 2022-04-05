package operating.system;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    menu();
  }

  public static void menu() throws NoSuchAlgorithmException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Single threaded mode");
    System.out.println("2. Multithreaded mode");
    System.out.print(">>> ");
    int menuArg = scanner.nextInt();
    switch (menuArg) {
      case 1:
        //Single

        int hashCount = 0;
        String[] hashArray = new String[10];

        for (; ; ) {
          System.out.print((hashCount + 1) + ". ");

          String hash = getHash();

          if (Objects.equals(hash, "0")) {
            break;
          }

          hashArray[hashCount] = hash;
          hashCount++;
        }

        System.out.println("\nStart encrypting...\n");

        long start = System.currentTimeMillis();

        for (int i = 0; i < hashCount; i++) {
          String password = SingleThreadedMode.encryptHash(hashArray[i]);
          System.out.println((i + 1) + ". " + password);
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("\nspent " + elapsed + " ms\n");

        menu();
      case 2:
        //Multi
        menu();
      default:
        System.out.println("\nWrong argument!\n");
        menu();
    }
  }

  public static String getHash() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter hash >>> ");
    return scanner.nextLine();
  }
}
