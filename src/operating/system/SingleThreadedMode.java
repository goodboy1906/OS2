package operating.system;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SingleThreadedMode {

  public static String encryptHash(String hash) throws NoSuchAlgorithmException {
    char[] passwordcheck = new char[5];
    char[] alf = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

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

              if (sb.toString().equals(hash)) {
                return password;
              }
            }
          }
        }
      }
    }
    return "No password found!";
  }


}
