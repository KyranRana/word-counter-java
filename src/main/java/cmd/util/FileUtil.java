package cmd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

  public static String readFile(File file) throws IOException {
    return new String(Files.readAllBytes(file.toPath()));
  }

  public static List<String> readFileLineByLine(File file) throws IOException {
    List<String> lines;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      lines = reader.lines().collect(Collectors.toList());
    }
    return lines;
  }
}
