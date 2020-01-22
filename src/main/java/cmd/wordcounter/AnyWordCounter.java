package cmd.wordcounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.javatuples.Pair;

/**
 * Counts occurrences of all UTF-16 words.
 *
 * @author kyranrana
 */
public class AnyWordCounter implements WordCounter {

  /**
   * Given text, counts occurrences of any word (regardless of whether or not it exists in a
   * dictionary) and returns a list of word and occurrence pairs. Case is ignored.
   *
   * @param text Text.
   * @return List of word and occurrence pairs.
   */
  @Override
  public List<Pair<String, Integer>> countWords(String text) {
    Map<String, Integer> words = new HashMap<>();
    StringBuilder wordBuilder = new StringBuilder();

    int lengthOfText = text.length();
    for (int i = 0; i <= lengthOfText; i++) {
      char character = i == lengthOfText ? 45 : text.charAt(i);
      if (Character.isLetter(character)) {
        wordBuilder.append(character);
      } else if (wordBuilder.length() > 0) {
        String word = wordBuilder.toString().toLowerCase();
        words.put(word, words.getOrDefault(word, 0) + 1);
        wordBuilder = new StringBuilder();
      }
    }

    return words.entrySet().stream()
        .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }
}
