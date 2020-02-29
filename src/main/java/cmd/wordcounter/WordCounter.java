package cmd.wordcounter;

import java.util.List;
import org.javatuples.Pair;

public interface WordCounter {

  List<Pair<String, Integer>> countWords(String text);
}
