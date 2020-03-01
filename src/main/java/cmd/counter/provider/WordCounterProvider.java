package cmd.counter.provider;

import cmd.counter.WordCounter;

public interface WordCounterProvider {

  WordCounter getWordCounter();
}
