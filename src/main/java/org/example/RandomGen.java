package org.example;

import java.util.Random;

public class RandomGen {
    private final int[] numbers;
    private final float[] probabilities;
    private final Random random;

    public RandomGen(int[] numbers, float[] probabilities) {
        if (numbers.length != probabilities.length) {
            throw new IllegalArgumentException("Numbers and probabilities must have the same length");
        }
        this.numbers = numbers;
        this.probabilities = probabilities;
        this.random = new Random();
    }

    public int nextNum() {
        float randomValue = random.nextFloat();
        float cumulativeProbability = 0;

        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];

            if (randomValue <= cumulativeProbability) {
                return numbers[i];
            }
        }

        // In case there is no number that matches the random value then throw, I would maybe seek out
        // further requirements on what to do when this is the case.
        throw new IllegalStateException("Could not generate the next number");
    }
}
