package com.github.javafaker;

import java.util.Random;

public class FlightNumbers {
    //faker object added here to emulate code in other files
    private final Faker faker;
    private Random rand;

    //Constructor added here to emulate code in other files
    protected FlightNumbers(Faker faker) {
        this.faker = faker;
        this.rand = new Random();
    }

    public String generateFlightString() {
        int random_int1 = this.rand.nextInt(10); //Generates random number from 0 to 9
        int random_int2 = this.rand.nextInt(10); //https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
        int random_int3 = this.rand.nextInt(10);
        int random_int4 = this.rand.nextInt(10);

        char char1 = (char)(this.rand.nextInt(26) + 'A'); //Generates random uppercase character
        char char2 = (char)(this.rand.nextInt(26) + 'A'); //https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java
        char char3 = (char)(this.rand.nextInt(26) + 'A');

        String toReturn = ""; //https://www.baeldung.com/java-string-initialization 

        int numLettersInName = 2 + this.rand.nextInt(1); //Get number of letters to include in flight number (either 2 or 3)

        if (numLettersInName == 2) {
            String toAppend1 = String.valueOf(char1); //https://www.javatpoint.com/java-char-to-string
            String toAppend2 = String.valueOf(char2);
            toReturn = toReturn + toAppend1; //https://www.javatpoint.com/string-concatenation-in-java
            toReturn = toReturn + toAppend2;
        } else {
            //numLettersInName = 3
            String toAppend1 = String.valueOf(char1);
            String toAppend2 = String.valueOf(char2);
            String toAppend3 = String.valueOf(char3);
            toReturn = toReturn + toAppend1;
            toReturn = toReturn + toAppend2;
            toReturn = toReturn + toAppend3;
        }

        int numDigitsInName = 1 + this.rand.nextInt(3); //Get number of digits to include in flight number (either 1, 2, 3, or 4)

        if (numDigitsInName == 1) {
            String toAppend1 = String.valueOf(random_int1);
            toReturn = toReturn + toAppend1;
        } else if (numDigitsInName == 2) {
            String toAppend1 = String.valueOf(random_int1);
            String toAppend2 = String.valueOf(random_int2);
            toReturn = toReturn + toAppend1;
            toReturn = toReturn + toAppend2;
        } else if (numDigitsInName == 3) {
            String toAppend1 = String.valueOf(random_int1);
            String toAppend2 = String.valueOf(random_int2);
            String toAppend3 = String.valueOf(random_int3);
            toReturn = toReturn + toAppend1;
            toReturn = toReturn + toAppend2;
            toReturn = toReturn + toAppend3;
        } else {
            //numDigitsInName = 4
            String toAppend1 = String.valueOf(random_int1);
            String toAppend2 = String.valueOf(random_int2);
            String toAppend3 = String.valueOf(random_int3);
            String toAppend4 = String.valueOf(random_int4);
            toReturn = toReturn + toAppend1;
            toReturn = toReturn + toAppend2;
            toReturn = toReturn + toAppend3;
            toReturn = toReturn + toAppend4;
        }

        return toReturn;

    }

    public String generateAirlineString() {
        String toReturn = faker.fakeValuesService().resolve("country.name", this, faker); //Uses code similar to that in Country.java which uses country.yml
        int randomCombo = this.rand.nextInt(3);
        if (randomCombo == 0) {
            //toReturn = toReturn + new String(" Air");
            toReturn = toReturn + " Air";
        } else if (randomCombo == 1) {
            // toReturn = toReturn + new String(" Airlines");
            toReturn = toReturn + " Airlines";
        } else {
            //randomCombo == 2
            //toReturn = new String("Air ") + toReturn;
            toReturn = "Air " + toReturn;
        }
        return toReturn;
    }
    
}