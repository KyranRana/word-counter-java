package cmd.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.javatuples.Pair;

public class AnyWordCounter implements WordCounter {

  @Override
  public List<Pair<String, Integer>> countWords(String text) {
    Map<String, Integer> occurrencesByWord = new HashMap<>();

    StringBuilder wordBuilder = new StringBuilder();

    int lengthOfText = text.length();
    for (int i = 0; i <= lengthOfText; i++) {
      char character = i == lengthOfText ? 45 : text.charAt(i);

      if (Character.isLetter(character)) {
        wordBuilder.append(character);
      } else if (wordBuilder.length() > 0) {
        String word = wordBuilder.toString().toLowerCase();
        occurrencesByWord.put(word, occurrencesByWord.getOrDefault(word, 0) + 1);
        wordBuilder = new StringBuilder();
      }
    }

    return occurrencesByWord.entrySet().stream()
        .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }
}
