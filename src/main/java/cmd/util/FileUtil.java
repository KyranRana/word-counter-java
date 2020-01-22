package cmd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * File utility class.
 *
 * @author kyranrana
 */
public class FileUtil {

  /**
   * Retrieves all data from {@link File}.
   *
   * @param file {@link File}
   * @return Data.
   * @throws IOException If problem occurs reading {@link File}.
   */
  public static String readFile(File file) throws IOException {
    return new String(Files.readAllBytes(file.toPath()));
  }

  /**
   * Retrieves data line by line from file located in resources.
   *
   * @param filePath Path to the file relative from resources folder.
   * @return Lines.
   * @throws IOException If problem occurs reading file.
   */
  public static List<String> readResourceFileLineByLine(String filePath) throws IOException {
    InputStream fileStream = FileUtil.class.getClassLoader().getResourceAsStream(filePath);
    if (fileStream == null) {
      throw new IOException("resource is null!");
    }

    List<String> lines = new ArrayList<>();
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream))) {

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
      }
    }

    return lines;
  }
}
