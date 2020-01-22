package cmd.printer;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link DefaultWordFrequencyPrinter}
 *
 * @author kyranrana
 */
public class DefaultWordFrequencyPrinterUnitTest {

  private final ByteArrayOutputStream customOut = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final String newLine = System.lineSeparator();

  @Before
  public void setupOutStream() {
    System.setOut(new PrintStream(customOut));
  }

  @After
  public void restoreOutStream() {
    System.setOut(originalOut);
  }

  /**
   * Scenario.
   *
   * <p>Given list of word and occurrence pairs.
   *
   * <p>And no custom comparator being set.
   *
   * <p>When {@link DefaultWordFrequencyPrinter#print()} is called
   *
   * <p>Then words and occurrences are printed, first ordered from most to least frequent, then
   * ordered alphabetically by word.
   */
  @Test
  public void print_withDefaultComparator() {
    List<Pair<String, Integer>> wordsAndOccurrences =
        new ArrayList<>(
            List.of(
                new Pair<>("hello", 2),
                new Pair<>("my", 3),
                new Pair<>("name", 4),
                new Pair<>("is", 1),
                new Pair<>("kyran", 1),
                new Pair<>("rana", 1),
                new Pair<>("and", 1),
                new Pair<>("i", 1),
                new Pair<>("like", 1),
                new Pair<>("to", 1),
                new Pair<>("program", 1)));

    new DefaultWordFrequencyPrinter(wordsAndOccurrences).print();

    Comparator<Pair<String, Integer>> cmp =
        Comparator.comparingInt(Pair<String, Integer>::getValue1)
            .reversed()
            .thenComparing(Pair::getValue0);

    String output =
        wordsAndOccurrences.stream()
                .sorted(cmp)
                .map(pair -> pair.getValue0() + ": " + pair.getValue1())
                .collect(Collectors.joining(newLine))
            + newLine;

    assertEquals(output, customOut.toString());
  }

  /**
   * Scenario.
   *
   * <p>Given list of word and occurrence pairs.
   *
   * <p>And custom comparator is set which sorts by least to most frequent, then by word
   * alphabetically.
   *
   * <p>When {@link DefaultWordFrequencyPrinter#print()} is called
   *
   * <p>Then words and occurrences are printed, first ordered by least to most frequent, then by
   * word alphabetically.
   */
  @Test
  public void print_withCustomComparator() {
    List<Pair<String, Integer>> wordsAndOccurrences =
        new ArrayList<>(
            List.of(
                new Pair<>("hello", 2),
                new Pair<>("my", 3),
                new Pair<>("name", 4),
                new Pair<>("is", 1),
                new Pair<>("kyran", 1),
                new Pair<>("rana", 1),
                new Pair<>("and", 1),
                new Pair<>("i", 1),
                new Pair<>("like", 1),
                new Pair<>("to", 1),
                new Pair<>("program", 1)));

    Comparator<Pair<String, Integer>> cmp =
        Comparator.comparingInt(Pair<String, Integer>::getValue1)
            .thenComparing(Pair::getValue0);

    new DefaultWordFrequencyPrinter(wordsAndOccurrences)
        .setComparator(cmp)
        .print();

    String output =
        wordsAndOccurrences.stream()
                .sorted(cmp)
                .map(pair -> pair.getValue0() + ": " + pair.getValue1())
                .collect(Collectors.joining(newLine))
            + newLine;

    assertEquals(output, customOut.toString());
  }
}
