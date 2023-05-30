# RandomGen

The `RandomGen` class generates random numbers based on provided probabilities. Given an array of numbers and corresponding probabilities, it uses a cumulative probability distribution to determine the next number to be generated.

## Usage

1. Instantiate the `RandomGen` class by providing an array of numbers and an array of corresponding probabilities:

```java
int[] numbers = {1, 2, 3};
float[] probabilities = {0.2f, 0.3f, 0.5f};
RandomGen randomGen = new RandomGen(numbers, probabilities);
```

2. Generate the next random number using the nextNum() method:
```java
int randomNumber = randomGen.nextNum();
```

The nextNum() method returns a random number from the provided array of numbers based on the given probabilities.

## Error Handling
If the lengths of the numbers and probabilities arrays are different, an IllegalArgumentException is thrown during the instantiation of the RandomGen class.

If no number matches the generated random value within the cumulative probability distribution, an IllegalStateException is thrown when calling the nextNum() method.

## Unit Tests
Unit tests for the RandomGen class are available in the RandomGenTest class. The tests ensure the correct generation of random numbers based on probabilities and validate the observed probabilities against the expected probabilities.

To run the unit tests, you can use a testing framework such as JUnit.

## Limitations
The algorithm assumes that the provided probabilities form a valid probability distribution, summing up to 1.0. It does not perform explicit checks for this condition.
