package cmd.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class FileUtilIntegrationTest {

  private static final String TEST_DIR_PREFIX = "util/fileutil";

  @Test(expected = IOException.class)
  public void readFile_whereFileDontExists() throws Exception {
    FileUtil.readFile(new File("some/wrong/path/nope.txt"));
  }

  @Test
  public void readFile_whereFileDoesExist() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();

    URL testFileURL = classLoader.getResource(TEST_DIR_PREFIX + "/read-file-test.txt");
    String fileURL = Objects.requireNonNull(testFileURL).getFile();

    assertEquals("This file does have content.", FileUtil.readFile(new File(fileURL)));
  }
}
