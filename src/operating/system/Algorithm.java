package operating.system;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Algorithm {

  public static ArrayList<String> singleThreadedMode() throws NoSuchAlgorithmException {
    ArrayList<String> hashList = getHash();
    ArrayList<String> passwordList = new ArrayList<>();
    char[] passwordcheck = new char[5];
    char[] alf = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    System.out.println("\nEncrypting...\n");

    outLoop: for (String s : hashList)
      for (int i = 0; i <= 25; ++i) {
        for (int j = 0; j <= 25; ++j) {
          for (int k = 0; k <= 25; ++k) {
            for (int l = 0; l <= 25; ++l) {
              for (int m = 0; m <= 25; ++m) {
                passwordcheck[0] = alf[i];
                passwordcheck[1] = alf[j];
                passwordcheck[2] = alf[k];
                passwordcheck[3] = alf[l];
                passwordcheck[4] = alf[m];

                String password = String.valueOf(passwordcheck);

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                for (byte b : hashInBytes) {
                  sb.append(String.format("%02x", b));
                }

                if (sb.toString().equals(s)) {
                  passwordList.add(password);
                  continue outLoop;
                }
              }
            }
          }
        }
      }
    return passwordList;
  }

  public static ArrayList<String> getHash() {
    ArrayList<String> getHashList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    for (int i = 1; ; i++) {
      System.out.print(i + ". Enter hash >>> ");
      String hashBuff = scanner.nextLine();
      if (Objects.equals(hashBuff, "0")) {
        return getHashList;
      }
      getHashList.add(hashBuff);
    }
  }

}
