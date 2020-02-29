package cmd.wordprinter;

import java.util.Comparator;
import java.util.List;
import org.javatuples.Pair;

public class DefaultWordFrequencyPrinter implements WordFrequencyPrinter {

  private final List<Pair<String, Integer>> wordsAndOccurrences;

  private Comparator<Pair<String, Integer>> comparator;

  public DefaultWordFrequencyPrinter(List<Pair<String, Integer>> wordsAndOccurrences) {
    this.wordsAndOccurrences = wordsAndOccurrences;

    this.comparator =
        Comparator.comparingInt(Pair<String, Integer>::getValue1)
            .reversed()
            .thenComparing(Pair::getValue0);
  }

  @Override
  public WordFrequencyPrinter withComparator(Comparator<Pair<String, Integer>> comparator) {
    this.comparator = comparator;
    return this;
  }

  @Override
  public void print() {
    wordsAndOccurrences.stream()
        .sorted(comparator)
        .forEach(
            wordAndOccurrence ->
                System.out.println(
                    wordAndOccurrence.getValue0() + ": " + wordAndOccurrence.getValue1()));
  }
}
