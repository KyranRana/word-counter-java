package cmd;

import cmd.counter.WordCounter;
import cmd.counter.provider.DefaultWordCounterProvider;
import cmd.printer.DefaultWordFrequencyPrinter;
import cmd.util.FileUtil;
import cmd.validation.DefaultInputFileValidation;
import java.io.File;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
    name = "wordfrequency",
    mixinStandardHelpOptions = true,
    version = "wordfrequency 1.0",
    description = "Outputs the word frequency of a text file")
public class WordFrequencyCmd implements Callable<Integer> {

  @Parameters(index = "0", description = "The text file to use")
  private File textFile;

  @Option(
      names = {"-m", "--mode"},
      description = "The type of word counter to use: (${COMPLETION-CANDIDATES})")
  private WordCounterMode mode = WordCounterMode.ANY;

  public static void main(String[] args) {
    System.exit(
        new CommandLine(new WordFrequencyCmd())
            .setExecutionExceptionHandler(new WordFrequencyCmdExceptionHandler())
            .execute(args));
  }

  @Override
  public Integer call() throws Exception {
    (new DefaultInputFileValidation()).validate(textFile);

    WordCounter wordCounter = new DefaultWordCounterProvider(mode).getWordCounter();
    new DefaultWordFrequencyPrinter(wordCounter.countWords(FileUtil.readFile(textFile))).print();

    return 0;
  }
}
