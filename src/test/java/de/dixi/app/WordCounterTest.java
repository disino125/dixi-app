package de.dixi.app;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

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
    void getMostWordOccurences_should_render_element_count_with_two_digits_correctly() {
        var text = repeat("Hase, ", 99);

        var result = WordCounter.getMostWordOccurences(text);

        assertEquals(result, "099 hase\n");
    }

    @Test
    void getMostWordOccurences_should_render_element_count_with_three_digits_correctly() {
        var text = repeat("Pferd, ", 999);

        var result = WordCounter.getMostWordOccurences(text);

        assertEquals(result, "999 pferd\n");
    }

    @Test
    void getMostWordOccurences_should_only_count_words() {
        var text = ""
                + "Die ☀️ ist hell; aber der \uD83C\uDF19 ist auch nicht zu verachten!\n"
                + "Äpfel,Birnen,Bananen: Diese 3 Dinge habe ich auf meiner Einkaufsliste.";

        var result = WordCounter.getMostWordOccurences(text);
        var expected = ""
                + "002 ist\n"
                + "001 aber\n"
                + "001 auch\n"
                + "001 auf\n"
                + "001 bananen\n"
                + "001 birnen\n"
                + "001 der\n"
                + "001 die\n"
                + "001 diese\n"
                + "001 dinge\n"
                + "001 einkaufsliste\n"
                + "001 habe\n"
                + "001 hell\n"
                + "001 ich\n"
                + "001 meiner\n"
                + "001 nicht\n"
                + "001 verachten\n"
                + "001 zu\n"
                + "001 äpfel\n";

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

    private String repeat(
            String s,
            int times) {
        return IntStream.range(0, times)
                .mapToObj(i -> s)
                .collect(joining());
    }

}