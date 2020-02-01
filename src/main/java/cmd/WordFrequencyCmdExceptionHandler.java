package cmd;

import java.io.FileNotFoundException;
import picocli.CommandLine;
import picocli.CommandLine.IExecutionExceptionHandler;
import picocli.CommandLine.ParseResult;

/**
 * Custom execution exception handler for {@link WordFrequencyCmd}
 *
 * @author kyranrana
 */
public class WordFrequencyCmdExceptionHandler implements IExecutionExceptionHandler {

  /**
   * Handles business logic exceptions thrown from {@link WordFrequencyCmd#call()}
   *
   * @param ex - The exception
   * @param commandLine - The associated commandLine
   * @param parseResult - The associated parseResult
   * @return The exit code
   */
  public int handleExecutionException(Exception ex,
      CommandLine commandLine,
      ParseResult parseResult) {

    commandLine.getErr().println(ex.getMessage());

    return commandLine.getExitCodeExceptionMapper() != null
        ? commandLine.getExitCodeExceptionMapper().getExitCode(ex)
        : commandLine.getCommandSpec().exitCodeOnExecutionException();
  }
}
