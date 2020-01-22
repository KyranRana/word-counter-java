package cmd.wordcounter;

import cmd.util.FileUtil;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.javatuples.Pair;

/**
 * Counts occurrences of all English words.
 *
 * @author kyranrana
 */
public class EnglishWordCounter extends AnyWordCounter {

  private final Map<String, Boolean> englishWords;

  public EnglishWordCounter() {
    try {
      englishWords =
          FileUtil.readResourceFileLineByLine("dictionary/english.txt").stream()
              .collect(Collectors.toMap(Function.identity(), v -> true));

    } catch (IOException e) {
      throw new RuntimeException("Failed to load data source!", e);
    }
  }

  /**
   * Given text, counts occurrences of words which exist in the english dictionary and returns a
   * list of word and occurrence pairs. Case is ignored.
   *
   * @param text Text.
   * @return List of word and occurrence pairs.
   */
  @Override
  public List<Pair<String, Integer>> countWords(String text) {
    return super.countWords(text).stream()
        .filter(pair -> englishWords.containsKey(pair.getValue0()))
        .collect(Collectors.toList());
  }
}
