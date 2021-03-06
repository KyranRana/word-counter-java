package cmd.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class ResourceUtilIntegrationTest {

  @Test(expected = IOException.class)
  public void readFileLineByLine_whereFileDontExists() throws Exception {
    ResourceFileUtil.readFileLineByLine("some/wrong/path/nope.txt");
  }

  @Test
  public void readFileLineByLine_whereFileDoesExist() throws Exception {
    assertEquals(
        List.of("This", "is", "a", "simple", "test"),
        ResourceFileUtil.readFileLineByLine("util/fileutil/read-file-line-by-line-test.txt"));
  }
}
