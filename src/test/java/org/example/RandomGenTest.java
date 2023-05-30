package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGenTest {
    private RandomGen randomGen;

    @BeforeEach
    public void setUp() {
        int[] numbers = {1, 2, 3};
        float[] probabilities = {0.2f, 0.3f, 0.5f};
        randomGen = new RandomGen(numbers, probabilities);
    }

    @Test
    public void testNextNum() {
        // Test if the generated number is one of the expected numbers
        int generatedNumber = randomGen.nextNum();
        boolean isExpectedNumber = generatedNumber == 1 || generatedNumber == 2 || generatedNumber == 3;
        assertTrue(isExpectedNumber);
    }

    @Test
    public void testNextNumMultipleTimes() {
        int num1Count = 0;
        int num2Count = 0;
        int num3Count = 0;
        int totalIterations = 10000; // Alot of iterations so we reduce the likelihood of false failures

        for (int i = 0; i < totalIterations; i++) {
            int generatedNumber = randomGen.nextNum();

            switch (generatedNumber) {
                case 1 -> num1Count++;
                case 2 -> num2Count++;
                case 3 -> num3Count++;
            }
        }

        // Calculate the observed probabilities based on the generated numbers
        float observedProbability1 = (float) num1Count / totalIterations;
        float observedProbability2 = (float) num2Count / totalIterations;
        float observedProbability3 = (float) num3Count / totalIterations;

        // Assert that the observed probabilities are close to the expected probabilities
        float epsilon = 0.01f; // Tolerance for comparing floats
        Assertions.assertEquals(0.2f, observedProbability1, epsilon, "Observed probability for number 1 is different from the expected probability");
        Assertions.assertEquals(0.3f, observedProbability2, epsilon, "Observed probability for number 2 is different from the expected probability");
        Assertions.assertEquals(0.5f, observedProbability3, epsilon, "Observed probability for number 3 is different from the expected probability");
    }

    @Test
    public void whenNumbersAndProbabilitiesAreNotSameLengthThenThrowException(){
        final int[] numbers = {-1, 0, };
        final float[] probabilities = {0.01f};

        Exception exception = assertThrows(RuntimeException.class, () -> new RandomGen(numbers, probabilities));

        String expectedMessage = "Numbers and probabilities must have the same length";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}