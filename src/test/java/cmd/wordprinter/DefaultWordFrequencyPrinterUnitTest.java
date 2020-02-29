package cmd.wordprinter;

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
        .withComparator(cmp)
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
