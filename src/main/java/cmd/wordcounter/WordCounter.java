package cmd.wordcounter;

import java.util.List;
import org.javatuples.Pair;

/**
 * Contract for word counter classes.
 *
 * @author kyranrana
 */
public interface WordCounter {

  /**
   * Given text, counts occurrences of specific words (dependent on implementation) and returns a
   * list of word and occurrence pairs. Case is ignored.
   *
   * @param text Text.
   * @return List of word and occurrence pairs.
   */
  List<Pair<String, Integer>> countWords(String text);
}
