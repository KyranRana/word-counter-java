package cmd.validation;

import cmd.exception.validation.FileNotReadableException;
import cmd.exception.validation.FileNotTextFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import org.junit.Test;

public class DefaultInputFileValidationIntegrationTest {

  private static final String TEST_DIR_PREFIX = "validation/defaultinputfilevalidation";

  private InputFileValidation inputFileValidation;
  private ClassLoader classLoader = getClass().getClassLoader();

  public DefaultInputFileValidationIntegrationTest() {
    inputFileValidation = new DefaultInputFileValidation();
  }

  @Test(expected = FileNotFoundException.class)
  public void validate_whereFileIsNotFound() throws Exception {
    inputFileValidation.validate(new File("nope.txt"));
  }

  @Test(expected = FileNotReadableException.class)
  public void validate_whereFileIsNotReadable() throws Exception {
    URL testFileURL = classLoader.getResource(TEST_DIR_PREFIX);
    String fileURL = Objects.requireNonNull(testFileURL).getFile();

    inputFileValidation.validate(new File(fileURL + "/file-not-readable-test.txt"));
  }

  @Test(expected = FileNotTextFileException.class)
  public void validate_whereFileIsNotTextFile() throws Exception {
    URL testFileURL = classLoader.getResource(TEST_DIR_PREFIX);
    String fileURL = Objects.requireNonNull(testFileURL).getFile();

    inputFileValidation.validate(new File(fileURL + "/file-not-text-file-test.pdf"));
  }
}
