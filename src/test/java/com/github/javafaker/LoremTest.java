package com.github.javafaker;

import com.github.javafaker.repeating.Repeat;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hamcrest.Matchers;
import org.junit.Test;

public class LoremTest extends AbstractFakerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoremTest.class);

    /* 
     * This test was created to understand the issue here: https://github.com/DiUS/java-faker/issues/666 
     */
    @Test 
    public void obtainIssueUnderstanding() {
        //Create random sentence of 255 random characters 
        logger.info("TESTING UNDERSTANDING of faker.lorem().characters(255): {}", faker.lorem().characters(255));

        //Creates a sentence with a random number of words: between 10 + 1, and 10 + 6 --> between 11 and 16 words
        logger.info("TESTING UNDERSTANDING of faker.lorem().sentence(10): {}", faker.lorem().sentence(10));

        //Get first 5 characters of a randomly generated sentence (possibly different from the one above) with a random number of words (between 10 + 1, and 10 + 6)
        logger.info("TESTING UNDERSTANDING of faker.lorem().sentence(10).substring(0, 5): {}", faker.lorem().sentence(10).substring(0, 5));
        
        //Get rid of leading and trailing whitespace
        logger.info("TESTING UNDERSTANDING of faker.lorem().sentence(10).substring(0, 5).trim(): {}", faker.lorem().sentence(10).substring(0, 5).trim());
    }

    /* 
     * This test was created to test the solution to the issue here: https://github.com/DiUS/java-faker/issues/666 
     * We perform the test by manually inspecting the output to ensure it meets the requirements
     */
    @Test
    @Repeat(times=10)
    public void testIssue666() {
        logger.info("TESTING SOLUTION TO ISSUE 666: {}", faker.lorem().maxLengthSentence(10));
    }

    @Test
    public void shouldCreateFixedLengthString() {
        assertEquals(10, faker.lorem().fixedString(10).length());
        assertEquals(50, faker.lorem().fixedString(50).length());
        assertEquals(0, faker.lorem().fixedString(0).length());
        assertEquals(0, faker.lorem().fixedString(-1).length());
    }

    @Test
    public void wordShouldNotBeNullOrEmpty() {
        assertThat(faker.lorem().word(), not(isEmptyOrNullString()));
    }

    @Test
    public void testCharacter() {
        assertThat(String.valueOf(faker.lorem().character()), matchesRegularExpression("[a-z\\d]{1}"));
    }

    @Test
    public void testCharacterIncludeUpperCase() {
        assertThat(String.valueOf(faker.lorem().character(false)), matchesRegularExpression("[a-z\\d]{1}"));
        assertThat(String.valueOf(faker.lorem().character(true)), matchesRegularExpression("[a-zA-Z\\d]{1}"));
    }

    @Test
    public void testCharacters() {
        assertThat(faker.lorem().characters(), matchesRegularExpression("[a-z\\d]{255}"));
    }

    @Test
    public void testCharactersIncludeUpperCase() {
        assertThat(faker.lorem().characters(false), matchesRegularExpression("[a-z\\d]{255}"));
        assertThat(faker.lorem().characters(true), matchesRegularExpression("[a-zA-Z\\d]{255}"));
    }

    @Test
    public void testCharactersWithLength() {
        assertThat(faker.lorem().characters(2), matchesRegularExpression("[a-z\\d]{2}"));
        assertThat(faker.lorem().characters(500), matchesRegularExpression("[a-z\\d]{500}"));
        assertThat(faker.lorem().characters(0), isEmptyString());
        assertThat(faker.lorem().characters(-1), isEmptyString());
    }

    @Test
    public void testCharactersWithLengthIncludeUppercase() {
        assertThat(faker.lorem().characters(2, false), matchesRegularExpression("[a-z\\d]{2}"));
        assertThat(faker.lorem().characters(500, false), matchesRegularExpression("[a-z\\d]{500}"));
        assertThat(faker.lorem().characters(2, true), matchesRegularExpression("[a-zA-Z\\d]{2}"));
        assertThat(faker.lorem().characters(500, true), matchesRegularExpression("[a-zA-Z\\d]{500}"));
        assertThat(faker.lorem().characters(0, false), isEmptyString());
        assertThat(faker.lorem().characters(-1, true), isEmptyString());
    }

    @Test
    public void testCharactersMinimumMaximumLength() {
        assertThat(faker.lorem().characters(1, 10), matchesRegularExpression("[a-z\\d]{1,10}"));
    }

    @Test
    public void testCharactersMinimumMaximumLengthIncludeUppercase() {
        assertThat(faker.lorem().characters(1, 10, true), matchesRegularExpression("[a-zA-Z\\d]{1,10}"));
    }

    @Test
    public void testCharactersMinimumMaximumLengthIncludeUppercaseIncludeDigit() {
        assertThat(faker.lorem().characters(1, 10, false, false), matchesRegularExpression("[a-zA-Z]{1,10}"));
        assertThat(faker.lorem().characters(1, 10, true, true), matchesRegularExpression("[a-zA-Z\\d]{1,10}"));
    }

    @Test
    public void testSentence() {
        assertThat(faker.lorem().sentence(), matchesRegularExpression("(\\w+\\s?){4,10}\\."));
    }

    @Test
    public void testSentenceWithWordCount() {
        assertThat(faker.lorem().sentence(10), matchesRegularExpression("(\\w+\\s?){11,17}\\."));
    }

    @Test
    public void testSentenceWithWordCountAndRandomWordsToAdd() {
        assertThat(faker.lorem().sentence(10, 10), matchesRegularExpression("(\\w+\\s?){10,20}\\."));
    }

    @Test
    public void testSentenceFixedNumberOfWords() {
        assertThat(faker.lorem().sentence(10, 0), matchesRegularExpression("(\\w+\\s?){10}\\."));
    }

    @Test
    public void testWords() {
        assertThat(faker.lorem().words(), hasSize(greaterThanOrEqualTo(1)));
    }
}
