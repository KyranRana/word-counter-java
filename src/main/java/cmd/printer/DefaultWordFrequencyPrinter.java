package cmd.printer;

import java.util.Comparator;
import java.util.List;
import org.javatuples.Pair;

/**
 * Default word frequency printer.
 *
 * <p>Given a list of word and occurrence pairs this frequency printer will by default print words
 * sorted by most frequent to less frequent. If two or more words have the same frequency these
 * words will be printed in alphabetical order. This behaviour can be completely changed by passing
 * through a custom comparator via {@link DefaultWordFrequencyPrinter#setComparator(Comparator)}.
 *
 * @author kyranrana
 */
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
  public WordFrequencyPrinter setComparator(Comparator<Pair<String, Integer>> comparator) {
    this.comparator = comparator;
    return this;
  }

  @Override
  public void print() {
    wordsAndOccurrences.stream()
        .sorted(comparator)
        .forEach(pair -> System.out.println(pair.getValue0() + ": " + pair.getValue1()));
  }
}
