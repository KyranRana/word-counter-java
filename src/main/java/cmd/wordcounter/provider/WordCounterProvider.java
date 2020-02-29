package cmd.wordcounter.provider;

import cmd.wordcounter.WordCounter;

public interface WordCounterProvider {

  WordCounter getWordCounter();
}
