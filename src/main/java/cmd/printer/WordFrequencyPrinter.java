package cmd.printer;

import java.util.Comparator;
import org.javatuples.Pair;

public interface WordFrequencyPrinter {

  WordFrequencyPrinter withComparator(Comparator<Pair<String, Integer>> comparator);

  void print();
}
