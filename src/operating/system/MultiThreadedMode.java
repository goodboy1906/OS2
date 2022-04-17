package operating.system;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MultiThreadedMode extends Thread {

  ArrayList<String> hashArray;
  ArrayList<String> passwordArray;
  int threadCount;

  MultiThreadedMode (ArrayList<String> inputHashArray, int inputThreadCount) {
    hashArray = new ArrayList<>(inputHashArray);
    threadCount = inputThreadCount;
  }

  public void run(){
    System.out.println(hashArray);
  }


}
