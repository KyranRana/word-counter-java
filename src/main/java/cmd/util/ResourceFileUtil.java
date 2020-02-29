package cmd.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class ResourceFileUtil {

  public static List<String> readFileLineByLine(File file) throws IOException, URISyntaxException {
    URL resource = ResourceFileUtil.class.getClassLoader().getResource(file.getPath());
    if (resource == null) throw new IOException("file not found!");
    return FileUtil.readFileLineByLine(new File(resource.toURI()));
  }
}
