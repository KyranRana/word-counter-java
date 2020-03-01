package cmd.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ResourceFileUtil {

  public static List<String> readFileLineByLine(String filePath) throws IOException {
    InputStream fileStream = ResourceFileUtil.class.getClassLoader().getResourceAsStream(filePath);

    if (fileStream == null) {
      throw new IOException("file not found!");
    }

    return FileUtil.readFileLineByLine(fileStream);
  }
}
