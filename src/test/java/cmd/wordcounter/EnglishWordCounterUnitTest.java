package cmd.wordcounter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.javatuples.Pair;
import org.junit.Test;

public class EnglishWordCounterUnitTest {

  private WordCounter englishWordCounter;

  public EnglishWordCounterUnitTest() {
    englishWordCounter = new EnglishWordCounter();
  }

  @Test
  public void countWords_withEnglishAndGibberishWords() {
    assertEquals(englishWordCounter.countWords("ndsfljfs dsfjdsfjksdf").size(), 0);

    assertContainSameItems(
        List.of(
            new Pair<>("hello", 1),
            new Pair<>("my", 1),
            new Pair<>("name", 1),
            new Pair<>("is", 1),
            new Pair<>("and", 1),
            new Pair<>("i", 1),
            new Pair<>("like", 1),
            new Pair<>("to", 1),
            new Pair<>("program", 1)),
        englishWordCounter.countWords("Hello, my name is Kyran Rana and I like to program"));

    assertContainSameItems(
        List.of(
            new Pair<>("this", 4),
            new Pair<>("is", 2),
            new Pair<>("a", 2),
            new Pair<>("simple", 2),
            new Pair<>("it", 2),
            new Pair<>("its", 4),
            new Pair<>("has", 2),
            new Pair<>("no", 2),
            new Pair<>("punctuation", 2),
            new Pair<>("but", 4),
            new Pair<>("made", 2),
            new Pair<>("for", 2),
            new Pair<>("the", 2),
            new Pair<>("purpose", 2),
            new Pair<>("of", 6),
            new Pair<>("test", 2),
            new Pair<>("testing", 2),
            new Pair<>("word", 4),
            new Pair<>("words", 4),
            new Pair<>("frequency", 4),
            new Pair<>("sentence", 2),
            new Pair<>("consists", 2),
            new Pair<>("mostly", 2),
            new Pair<>("english", 6),
            new Pair<>("you", 2),
            new Pair<>("see", 2),
            new Pair<>("what", 2),
            new Pair<>("i", 2),
            new Pair<>("mean", 2),
            new Pair<>("used", 2),
            new Pair<>("to", 2),
            new Pair<>("ensure", 2),
            new Pair<>("that", 2),
            new Pair<>("counter", 2),
            new Pair<>("only", 4),
            new Pair<>("measures", 2),
            new Pair<>("dir", 7)),
        englishWordCounter.countWords(
            "This is a simple test it has no punctuation but its "
                + " made for the purpose of testing word frequency This sentence consists of mostly "
                + " english words nothere but you see what i mean its used to ensure ignorethis that "
                + " english word counter only measures frequency of english words only "
                + ""
                + "This is a simple test it has no punctuation but its "
                + " made for the purpose of testing word frequency This sentence consists of mostly "
                + " english words nothere but you see what i mean its used to ensure ignorethis that "
                + " english word counter only measures frequency of english words only "
                + ""
                + "lorem ipsum dir amet lorem ipsum dir amet lorem ipsum dir amet lorem ipsum dir "
                + "amet lorem ipsum dir amet lorem ipsum dir amet lorem ipsum dir amet"));
  }

  @Test
  public void countWords_withEnglishAndGibberishWordsHavingPunctuationAndSpecialLetters() {
    assertContainSameItems(
        List.of(
            new Pair<>("hello", 1),
            new Pair<>("my", 1),
            new Pair<>("name", 1),
            new Pair<>("is", 1),
            new Pair<>("and", 1),
            new Pair<>("i", 1),
            new Pair<>("like", 1),
            new Pair<>("to", 1),
            new Pair<>("program", 1)),
        englishWordCounter.countWords("Hello, my name is Kyran Rana, and I like to program!"));

    assertContainSameItems(
        List.of(
            new Pair<>("hello", 11),
            new Pair<>("my", 9),
            new Pair<>("name", 9),
            new Pair<>("is", 9),
            new Pair<>("and", 9),
            new Pair<>("i", 9),
            new Pair<>("like", 9),
            new Pair<>("to", 9),
            new Pair<>("program", 9)),
        englishWordCounter.countWords(
            "Hello. Hello. Hello, my name is Kyran Rana, and "
                + "I like to program! (Hello, my name is Kyran Rana, and I like to program!) (Hello, my name "
                + "is Kyran Rana, and I like to program!) Hello, my name is Kyran Rana, and I like to "
                + "program! Hello, my name is Kyran Rana, and I like to program! Hello, my name is Kyran "
                + "Rana, and I like to program! Hello, my name is Kyran Rana, and I like to program! "
                + "Hello, my name is Kyran Rana, and I like to program! Hello, my name is Kyran Rana, and "
                + "I like to program!"));

    assertContainSameItems(
        List.of(
            new Pair<>("hello", 2),
            new Pair<>("aaa", 1),
            new Pair<>("well", 1),
            new Pair<>("this", 3),
            new Pair<>("is", 2),
            new Pair<>("some", 4),
            new Pair<>("gibberish", 3),
            new Pair<>("and", 1),
            new Pair<>("text", 5),
            new Pair<>("has", 1),
            new Pair<>("repetitive", 1),
            new Pair<>("more", 1),
            new Pair<>("punctuation", 1),
            new Pair<>("should", 1),
            new Pair<>("be", 1),
            new Pair<>("ignored", 1)),
        englishWordCounter.countWords(
            "gibberish, and gibberish text!! (aaa bbbb ssjcjd cjdd djfjk djfjk djfjk) This has some "
                + "Hello.. Hello. Well this is some gibberish, "
                + "repetitive text, text, text. This is some more text. Some punctuation! &^%*@& should be "
                + "ignored."));

    assertContainSameItems(
        List.of(
            new Pair<>("first", 2),
            new Pair<>("download", 2),
            new Pair<>("a", 4),
            new Pair<>("word", 4),
            new Pair<>("code", 2),
            new Pair<>("list", 4),
            new Pair<>("from", 2),
            new Pair<>("for", 2),
            new Pair<>("example", 2),
            new Pair<>("here", 2),
            new Pair<>("place", 2),
            new Pair<>("it", 2),
            new Pair<>("in", 2),
            new Pair<>("the", 6),
            new Pair<>("root", 2),
            new Pair<>("directory", 2),
            new Pair<>("to", 2),
            new Pair<>("check", 2),
            new Pair<>("whether", 2),
            new Pair<>("string", 2),
            new Pair<>("of", 4),
            new Pair<>("or", 2),
            new Pair<>("your", 2),
            new Pair<>("part", 2),
            new Pair<>("project", 2),
            new Pair<>("is", 2),
            new Pair<>("use", 2),
            new Pair<>("following", 2),
            new Pair<>("not", 2)),
        englishWordCounter.countWords(
            "First, download a word list from for example here. "
                + "Place it in the root directory of your project. Use the following code to check "
                + "whether a String is part of the word list or not: (sdjdskf sdfkdskfdf awejo) "
                + "First, download a word list from for example here. Place it in the root directory "
                + "of your project. Use the following code to check whether a String is part of the "
                + "word list or not: (dsfl;dsfk dfe-llko,vsadsadsa dfskfsdf) dfgfd asldasld rkrlrl"));
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
