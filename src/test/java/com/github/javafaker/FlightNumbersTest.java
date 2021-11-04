package com.github.javafaker;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.junit.Assert.assertThat;

public class FlightNumbersTest extends AbstractFakerTest {
    private static final Logger logger = LoggerFactory.getLogger(FlightNumbersTest.class);

    @Test
    public void testCode() {
        for (int i = 0; i < 10; i++) {
            logger.info("Testing 123 yay!!! {} to {} yayy!!! {}", -i, i, "testString");
        }
    }
}