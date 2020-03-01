package cmd.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class FileUtilIntegrationTest {

  private static final String TEST_DIR_PREFIX = "util/fileutil";

  private final ClassLoader classLoader;
  private final String testDirPrefix;

  public FileUtilIntegrationTest() {
    classLoader = getClass().getClassLoader();
    testDirPrefix = Objects.requireNonNull(classLoader.getResource(TEST_DIR_PREFIX)).getFile();
  }

  @Test(expected = IOException.class)
  public void readFile_whereFileDontExists() throws Exception {
    FileUtil.readFile(new File("some/wrong/path/nope.txt"));
  }

  @Test
  public void readFile_whereFileDoesExist() throws Exception {
    assertEquals(
        "This file does have content.",
        FileUtil.readFile(new File(testDirPrefix + "/read-file-test.txt")));
  }

  @Test(expected = IOException.class)
  public void readFileLineByLine_whereFileDontExists() throws Exception {
    FileUtil.readFileLineByLine(new File("some/wrong/path/nope.txt"));
  }

  @Test
  public void readFileLineByLine_whereFileDoesExist() throws Exception {
    assertEquals(
        Arrays.asList("This", "is", "a", "simple", "test"),
        FileUtil.readFileLineByLine(new File(testDirPrefix + "/read-file-line-by-line-test.txt")));
  }

  @Test
  public void readFileLineByLine_whereFileDoesExist_streamVariation() throws Exception {
    assertEquals(
        Arrays.asList("This", "is", "a", "simple", "test"),
        FileUtil.readFileLineByLine(
            classLoader.getResourceAsStream(TEST_DIR_PREFIX + "/read-file-line-by-line-test.txt")));
  }
}
