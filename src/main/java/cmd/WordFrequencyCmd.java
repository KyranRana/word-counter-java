package cmd;

import cmd.wordprinter.DefaultWordFrequencyPrinter;
import cmd.wordprinter.WordFrequencyPrinter;
import cmd.util.FileUtil;
import cmd.wordcounter.WordCounter;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.Callable;
import org.javatuples.Pair;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * Word frequency command.
 *
 * <p>This program utilises a package called Picoli which is a mini command line framework. The
 * reason I used this framework is because it allows the usage of parameters and named options
 * totally through the use of annotations. I felt this was convenient considering it allows this
 * word counter cli to become more flexible going forward regarding the arguments it accepts.
 *
 * <p>For example as an extra feature for this test, I added a --mode option to this word counter to
 * allow the user to choose between different word counter implementations e.g. using a word counter
 * which specifically counts English words.
 *
 * @author kyranrana
 */
@Command(
    name = "wordfrequency",
    mixinStandardHelpOptions = true,
    version = "wordfrequency 1.0",
    description = "Outputs the word frequency of a text file")
public class WordFrequencyCmd implements Callable<Integer> {

  @Parameters(index = "0", description = "The text file")
  private File textFile;

  @Option(
      names = {"-m", "--mode"},
      description = "The type of word counter to use: (${COMPLETION-CANDIDATES})")
  private WordCounterMode mode = WordCounterMode.ANY;

  /**
   * Main entry point. Will take args provided by the user and pass them through to the Picocli
   * {@link CommandLine} framework, this framework will validate mandatory arguments have been
   * provided and finally mutate all annotated properties with their respective values. Once this is
   * done {@link WordFrequencyCmd#call()} will be invoked.
   *
   * @see WordFrequencyCmd#call() for business logic.
   * @param args The raw command line arguments.
   */
  public static void main(String[] args) {
    int exitCode =
        new CommandLine(new WordFrequencyCmd())
            .setExecutionExceptionHandler(new WordFrequencyCmdExceptionHandler())
            .execute(args);

    System.exit(exitCode);
  }

  /**
   * Handles business logic for {@link WordFrequencyCmd}. This involves:
   *
   * <p>1. Checking the provided file exists, is accessible, and is a text file.
   *
   * <p>2. Counting words in the text file using the selected {@link WordCounter} implementation.
   *
   * <p>3. Printing consistently sorted word and occurrence pairs using {@link WordFrequencyPrinter}
   *
   * @return The exit code.
   */
  @Override
  public Integer call() throws Exception {
    String absolutePath = textFile.toPath().toString();

    if (!textFile.exists())
      throw new IOException(String.format("File \"%s\" does not exist!", absolutePath));

    if (!textFile.canRead())
      throw new IOException(String.format("File \"%s\" is not readable!", absolutePath));

    if (!URLConnection.getFileNameMap().getContentTypeFor(textFile.getName()).equals("text/plain"))
      throw new IOException(String.format("File \"%s\" is not a text file!", absolutePath));

    String textFileData = FileUtil.readFile(textFile);

    List<Pair<String, Integer>> wordsAndOccurrences =
        mode.getWordCounter().countWords(textFileData);

    new DefaultWordFrequencyPrinter(wordsAndOccurrences).print();

    return 0;
  }
}
