package com.github.javafaker;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.junit.Assert.assertEquals;

public class FlightNumbersTest extends AbstractFakerTest {
    private static final Logger logger = LoggerFactory.getLogger(FlightNumbersTest.class);

    /**
     * This test is used to confirm that our logger is working correctly as we intended it to
     */
    @Test
    public void testCode() {
        for (int i = 0; i < 10; i++) {
            logger.info("Testing 123 yay!!! {} to {} yayy!!! {}", -i, i, "testString");
        }
    }

    /** 
     * This test is used to print out/log a randomly generated flight string so we can manually confirm that the function is working as intended. 
     */
    @Test 
    public void testCode2() {
        logger.info("Testing generating random flight: {}", faker.flightNumbers().generateFlightString());
    }

    /** 
     * This test is used to print out/log a randomly generated airline name so we can manually confirm that the function is working as intended. 
     */
    @Test 
    public void testCode3() {
        logger.info("Testing generating random airline name: {}", faker.flightNumbers().generateAirlineString());
    }
}