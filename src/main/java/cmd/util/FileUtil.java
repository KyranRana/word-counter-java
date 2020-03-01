package cmd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

  public static String readFile(File file) throws IOException {
    return new String(Files.readAllBytes(file.toPath()));
  }

  public static List<String> readFileLineByLine(File file) throws IOException {
    return readFileLineByLine(new FileReader(file));
  }

  public static List<String> readFileLineByLine(InputStream fileStream) throws IOException {
    return readFileLineByLine(new InputStreamReader(fileStream));
  }

  private static List<String> readFileLineByLine(Reader source) throws IOException {
    List<String> lines;

    try (BufferedReader reader = new BufferedReader(source)) {
      lines = reader.lines().collect(Collectors.toList());
    }

    return lines;
  }
}
