package cmd.counter;

import cmd.util.ResourceFileUtil;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.javatuples.Pair;

public class EnglishWordCounter extends AnyWordCounter {

  private final Map<String, Boolean> englishWords;

  public EnglishWordCounter() {
    try {
      englishWords =
          ResourceFileUtil.readFileLineByLine("dictionary/english.txt").stream()
              .collect(Collectors.toMap(Function.identity(), v -> true));

    } catch (IOException e) {
      throw new RuntimeException("Failed to load data source!", e);
    }
  }

  @Override
  public List<Pair<String, Integer>> countWords(String text) {
    return super.countWords(text).stream()
        .filter(wordAndOccurrence -> englishWords.containsKey(wordAndOccurrence.getValue0()))
        .collect(Collectors.toList());
  }
}
