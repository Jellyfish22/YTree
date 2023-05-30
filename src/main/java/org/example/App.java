package org.example;

public class App {
    public static void main( String[] args ) {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        RandomGen generator = new RandomGen(numbers, probabilities);

        int numCalls = 100;
        int[] results = new int[numbers.length];

        for (int i = 0; i < numCalls; i++) {
            int num = generator.nextNum();

            for (int j = 0; j < numbers.length; j++) {
                if (num == numbers[j]) {
                    results[j]++;
                    break;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + ": " + results[i] + " times");
        }
    }
}
