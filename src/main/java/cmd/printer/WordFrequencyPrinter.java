package cmd.printer;

import java.util.Comparator;
import org.javatuples.Pair;

/**
 * Contract for a word frequency printer.
 *
 * @author kyranrana
 */
public interface WordFrequencyPrinter {

  /**
   * Sets comparator to use for sorting word and occurrence pairs. Default sort will first sort
   * occurrences by most frequent to least frequent, and if two or more words have the same
   * frequency those words are sorted alphabetically.
   *
   * @param comparator Comparator.
   */
  WordFrequencyPrinter setComparator(Comparator<Pair<String, Integer>> comparator);

  /**
   * Prints sorted word and occurrence pairs using comparator set through {@link
   * WordFrequencyPrinter#setComparator(Comparator)} to STDOUT. If no comparator has been set
   * default sort will first sort occurrences by most frequent to least frequent, and if two or more
   * words have the same frequency those words are sorted alphabetically.
   */
  void print();
}
