package cmd.wordcounter.provider;

import cmd.WordCounterMode;
import cmd.wordcounter.AnyWordCounter;
import cmd.wordcounter.EnglishWordCounter;
import cmd.wordcounter.WordCounter;
import java.util.Map;
import lombok.Getter;

public class DefaultWordCounterProvider implements WordCounterProvider {

  private static final Map<WordCounterMode, WordCounter> wordCounters =
      Map.ofEntries(
          Map.entry(WordCounterMode.ANY, new AnyWordCounter()),
          Map.entry(WordCounterMode.ENGLISH, new EnglishWordCounter()));

  @Getter private final WordCounter wordCounter;

  public DefaultWordCounterProvider(WordCounterMode mode) {
    wordCounter = wordCounters.get(mode);
  }
}
