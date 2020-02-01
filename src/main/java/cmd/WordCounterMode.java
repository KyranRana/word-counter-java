package cmd;

import cmd.counter.AnyWordCounter;
import cmd.counter.EnglishWordCounter;
import cmd.counter.WordCounter;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Valid word counter modes.
 *
 * <p>Since there could potentially be many word counter modes this enhanced enum associates each
 * word counter mode with its respective word counter implementation. This avoids the use of if-else
 * statements and allows us to get at the implementation using {@link
 * WordCounterMode#getWordCounter()}
 *
 * @author kyranrana
 */
@AllArgsConstructor
public enum WordCounterMode {
  ANY(new AnyWordCounter()),
  ENGLISH(new EnglishWordCounter());

  @Getter private WordCounter wordCounter;
}
