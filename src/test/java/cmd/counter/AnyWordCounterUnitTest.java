package cmd.counter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.javatuples.Pair;
import org.junit.Test;

public class AnyWordCounterUnitTest {

  private WordCounter anyWordCounter;

  public AnyWordCounterUnitTest() {
    anyWordCounter = new AnyWordCounter();
  }

  @Test
  public void countWords_withRealAndGibberishWords1() {
    assertContainSameItems(
        List.of(
            new Pair<>("hello", 1),
            new Pair<>("my", 1),
            new Pair<>("name", 1),
            new Pair<>("is", 1),
            new Pair<>("kyran", 1),
            new Pair<>("rana", 1),
            new Pair<>("and", 1),
            new Pair<>("i", 1),
            new Pair<>("like", 1),
            new Pair<>("to", 1),
            new Pair<>("program", 1)),
        anyWordCounter.countWords("Hello my name is Kyran Rana and I like to program"));
  }

  @Test
  public void countWords_withRealAndGibberishWords2() {
    assertContainSameItems(
        List.of(
            new Pair<>("lorem", 1),
            new Pair<>("ipsum", 1),
            new Pair<>("dolor", 1),
            new Pair<>("sit", 1),
            new Pair<>("amet", 1),
            new Pair<>("consectetur", 1),
            new Pair<>("adipiscing", 1),
            new Pair<>("elit", 1),
            new Pair<>("sed", 1),
            new Pair<>("do", 1),
            new Pair<>("eiusmod", 1),
            new Pair<>("tempor", 2),
            new Pair<>("incididunt", 1),
            new Pair<>("ut", 2),
            new Pair<>("labore", 1),
            new Pair<>("et", 3),
            new Pair<>("dolore", 1),
            new Pair<>("magna", 1),
            new Pair<>("aliqua", 1),
            new Pair<>("non", 1),
            new Pair<>("sodales", 2),
            new Pair<>("neque", 2),
            new Pair<>("gravida", 1),
            new Pair<>("arcu", 1),
            new Pair<>("ac", 2),
            new Pair<>("tortor", 2),
            new Pair<>("dignissim", 1),
            new Pair<>("convallis", 1),
            new Pair<>("aenean", 1),
            new Pair<>("ultricies", 1),
            new Pair<>("mi", 1),
            new Pair<>("eget", 1),
            new Pair<>("mauris", 1),
            new Pair<>("pharetra", 1),
            new Pair<>("ultrices", 1),
            new Pair<>("vel", 1),
            new Pair<>("eros", 1),
            new Pair<>("donec", 1),
            new Pair<>("odio", 1),
            new Pair<>("orci", 1)),
        anyWordCounter.countWords(
            "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor "
                + "incididunt ut labore et dolore magna aliqua Non sodales neque sodales ut "
                + "Gravida arcu ac tortor dignissim convallis aenean et tortor Ultricies mi "
                + "eget mauris pharetra et ultrices neque Vel eros donec ac odio tempor orci"));
  }

  @Test
  public void countWords_withRealAndGibberishWords3() {
    assertContainSameItems(
        List.of(
            new Pair<>("hey", 1),
            new Pair<>("there", 1),
            new Pair<>("name", 3),
            new Pair<>("random", 1),
            new Pair<>("text", 1),
            new Pair<>("love", 1),
            new Pair<>("this", 1),
            new Pair<>("kyran", 5),
            new Pair<>("test", 1),
            new Pair<>("gibberish", 1),
            new Pair<>("aa", 3),
            new Pair<>("bbb", 1),
            new Pair<>("b", 4)),
        anyWordCounter.countWords(
            "Hey there name name name random text "
                + "love this kyran kyran kyran test kyran kyran gibberish aa aa aa bbb b b b b"));
  }

  @Test
  public void countWords_withRealAndGibberishWords4() {
    assertContainSameItems(
        List.of(
            new Pair<>("hey", 3),
            new Pair<>("there", 3),
            new Pair<>("name", 9),
            new Pair<>("random", 3),
            new Pair<>("gibberish", 3),
            new Pair<>("text", 3),
            new Pair<>("love", 3),
            new Pair<>("this", 3),
            new Pair<>("kyran", 15),
            new Pair<>("test", 3),
            new Pair<>("aa", 9),
            new Pair<>("bbb", 3),
            new Pair<>("b", 12)),
        anyWordCounter.countWords(
            "Hey there name name name random text "
                + "love this kyran kyran kyran test kyran kyran gibberish aa aa aa bbb b b b b "
                + ""
                + "Hey there name name name random text "
                + "love this kyran kyran kyran test kyran kyran gibberish aa aa aa bbb b b b b "
                + "Hey there name name name random text "
                + "love this kyran kyran kyran test kyran kyran gibberish aa aa aa bbb b b b b "));
  }

  @Test
  public void countWords_withRealAndGibberishWords5() {
    assertContainSameItems(
        List.of(
            new Pair<>("tomo", 3),
            new Pair<>("clases", 3),
            new Pair<>("para", 3),
            new Pair<>("aprender", 3),
            new Pair<>("español", 3),
            new Pair<>("buenos", 6),
            new Pair<>("días", 3),
            new Pair<>("día", 3),
            new Pair<>("adiós", 4)),
        anyWordCounter.countWords(
            "Tomo clases para aprender español Buenos días "
                + "Buenos días Buenos días Tomo clases para aprender español Tomo clases para aprender "
                + "español Adiós Buenos día Adiós Adiós Adiós Buenos día Buenos día"));
  }

  @Test
  public void countWords_withRealAndGibberishWordsHavingPunctuationAndSpecialLetters1() {
    assertContainSameItems(
        List.of(
            new Pair<>("hello", 1),
            new Pair<>("my", 1),
            new Pair<>("name", 1),
            new Pair<>("is", 1),
            new Pair<>("kyran", 1),
            new Pair<>("rana", 1),
            new Pair<>("and", 1),
            new Pair<>("i", 1),
            new Pair<>("like", 1),
            new Pair<>("to", 1),
            new Pair<>("program", 1)),
        anyWordCounter.countWords("Hello, my name is Kyran Rana, and I like to program!"));
  }

  @Test
  public void countWords_withRealAndGibberishWordsHavingPunctuationAndSpecialLetters2() {
    assertContainSameItems(
        List.of(
            new Pair<>("hello", 2),
            new Pair<>("well", 1),
            new Pair<>("this", 3),
            new Pair<>("is", 2),
            new Pair<>("some", 4),
            new Pair<>("gibberish", 3),
            new Pair<>("and", 1),
            new Pair<>("text", 5),
            new Pair<>("aaa", 1),
            new Pair<>("bbbb", 1),
            new Pair<>("ssjcjd", 1),
            new Pair<>("cjdd", 1),
            new Pair<>("djfjk", 3),
            new Pair<>("has", 1),
            new Pair<>("repetitive", 1),
            new Pair<>("more", 1),
            new Pair<>("punctuation", 1),
            new Pair<>("should", 1),
            new Pair<>("be", 1),
            new Pair<>("ignored", 1)),
        anyWordCounter.countWords(
            "gibberish, and gibberish text!! (aaa bbbb ssjcjd cjdd djfjk djfjk djfjk) This has some "
                + "Hello.. Hello. Well this is some gibberish, "
                + "repetitive text, text, text. This is some more text. Some punctuation! &^%*@& should be "
                + "ignored."));
  }

  @Test
  public void countWords_withRealAndGibberishWordsHavingPunctuationAndSpecialLetters3() {
    assertContainSameItems(
        List.of(
            new Pair<>("hello", 11),
            new Pair<>("my", 9),
            new Pair<>("name", 9),
            new Pair<>("is", 9),
            new Pair<>("kyran", 9),
            new Pair<>("rana", 9),
            new Pair<>("and", 9),
            new Pair<>("i", 9),
            new Pair<>("like", 9),
            new Pair<>("to", 9),
            new Pair<>("program", 9)),
        anyWordCounter.countWords(
            "Hello. Hello. Hello, my name is Kyran Rana, and "
                + "I like to program! (Hello, my name is Kyran Rana, and I like to program!) (Hello, my name "
                + "is Kyran Rana, and I like to program!) Hello, my name is Kyran Rana, and I like to "
                + "program! Hello, my name is Kyran Rana, and I like to program! Hello, my name is Kyran "
                + "Rana, and I like to program! Hello, my name is Kyran Rana, and I like to program! "
                + "Hello, my name is Kyran Rana, and I like to program! Hello, my name is Kyran Rana, and "
                + "I like to program!"));
  }

  @Test
  public void countWords_withRealAndGibberishWordsHavingPunctuationAndSpecialLetters4() {
    assertContainSameItems(
        List.of(
            new Pair<>("buenos", 11),
            new Pair<>("días", 11),
            new Pair<>("señor", 5),
            new Pair<>("es", 5),
            new Pair<>("usted", 8),
            new Pair<>("norteamericano", 5),
            new Pair<>("habla", 3),
            new Pair<>("español", 3)),
        anyWordCounter.countWords(
            "Buenos días. Buenos días. Buenos días. Buenos días. Buenos días. Buenos días. "
                + "Buenos días Señor. ¿Es usted norteamericano? Buenos días Señor. ¿Es usted "
                + "norteamericano? Buenos días Señor. ¿Es usted norteamericano? Buenos días Señor. "
                + "¿Es usted norteamericano? Buenos días Señor. ¿Es usted norteamericano? ¿Usted "
                + "habla Español? ¿Usted habla Español? ¿Usted habla Español?"));
  }

  private void assertContainSameItems(
      List<Pair<String, Integer>> expected, List<Pair<String, Integer>> actual) {

    List<Pair<String, Integer>> theExpected = new ArrayList<>(expected);
    List<Pair<String, Integer>> theActual = new ArrayList<>(actual);

    Comparator<Pair<String, Integer>> byOccurrencesThenWord =
        Comparator.comparingInt(Pair<String, Integer>::getValue1).thenComparing(Pair::getValue0);

    theExpected.sort(byOccurrencesThenWord);
    theActual.sort(byOccurrencesThenWord);

    assertEquals(theExpected, theActual);
  }
}
