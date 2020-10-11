package de.dixi.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WordCounterTest {

    @Test
    void getMostWordOccurences_should_return_a_list_of_word_occurrences() {
        var text = ""
                + "Ein Pferd, ist ein vierbeiniges Tier.\n "
                + "Nicht jedes Tier hat vier Beine. Ein Vogel hat nur zwei Beine.\n"
                + "Ein Pferd hat aber vier Beine.";

        var result = WordCounter.getMostWordOccurences(text);

        var expected = ""
                + "004 ein\n"
                + "003 beine\n"
                + "003 hat\n"
                + "002 pferd\n"
                + "002 tier\n"
                + "002 vier\n"
                + "001 aber\n"
                + "001 ist\n"
                + "001 jedes\n"
                + "001 nicht\n"
                + "001 nur\n"
                + "001 vierbeiniges\n"
                + "001 vogel\n"
                + "001 zwei\n";

        assertEquals(result, expected);
    }

    @Test
    void getMostWordOccurences_should_return_empty_string_when_given_empty_string() {
        assertEquals(WordCounter.getMostWordOccurences(""), "");
    }

    @Test
    void getMostWordOccurences_should_return_empty_string_when_given_null() {
        assertEquals(WordCounter.getMostWordOccurences(null), "");
    }

}